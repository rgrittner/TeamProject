package com.reneegrittner.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@Path("/Compositions")

public class Compositions {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<Composition> dao = new GenericDao<>(Composition.class);

    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveAllCompositionsJson() throws IOException {

        List<Composition> compositionResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(compositionResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response retrieveAllComposersXml() throws IOException {

        List<Composition> CompositionResultSet = dao.getAll();

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = mapper.writeValueAsString(CompositionResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/{param}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response compositionsByProvidedComposerJson(@PathParam("param") String composerLastName) throws JsonProcessingException {
        GenericDao<Composer> localDao = new GenericDao<>(Composer.class);
        int composerId = 0;

        // Search by property, this returns a list
        List<Composer> composerList = localDao.getByPropertyEqual("lastName", composerLastName);
        logger.debug(composerList);

        //Error handling? Continue if there is only one result in the list
        if(composerList.size() == 1){

            // Get the id for the one returned nationality. Only expecting one, so should be at position 0.
            composerId = composerList.get(0).getId();

            // Now query for list of composers using the ID
            List<Composition> compositionsBySpecificComposerResultSet = dao.getByPropertyEqual("composer", composerId);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String output = objectMapper.writeValueAsString(compositionsBySpecificComposerResultSet);

            return Response.status(200).entity(output).build();
        } else {
            // If no composers are returned send a nice message. Couldn't find a good error code for this,
            // not sure if an error code is even the right response. Or, should it just send back an empty json object?
            String errorMessage = "There are currently no compositions with a composer of " + composerLastName;
            return Response.status(200).entity(errorMessage).build();
        }

    }
/*
    @GET
    @Path("/{param}/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response compositionsByProvidedComposerXml(@PathParam("param") String composerLastName) throws JsonProcessingException {
        GenericDao<Composer> localDao = new GenericDao<>(Composer.class);
        int composerId = 0;

        // Search by property, this returns a list
        List<Composer> composerList = localDao.getByPropertyEqual("lastName", composerLastName);
        logger.debug(composerList);

        //Error handling? Continue if there is only one result in the list
        if(composerList.size() == 1){

            // Get the id for the one returned nationality. Only expecting one, so should be at position 0.
            composerId = composerList.get(0).getId();

            // Now query for list of composers using the ID
            List<Composition> compositionsBySpecificComposerResultSet = dao.getByPropertyEqual("composer", composerId);

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String output = xmlMapper.writeValueAsString(compositionsBySpecificComposerResultSet);

            return Response.status(200).entity(output).build();
        } else {
            // If no composers are returned send a nice message. Couldn't find a good error code for this,
            // not sure if an error code is even the right response. Or, should it just send back an empty json object?
            String errorMessage = "There are currently no compositions with a composer of " + composerLastName;
            return Response.status(200).entity(errorMessage).build();
        }

    }
*/


}

