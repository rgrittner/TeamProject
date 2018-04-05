package com.reneegrittner.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;
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


@Path("/Composers")

public class Composers {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<Composer> dao = new GenericDao<>(Composer.class);

    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveAllComposersJson() throws IOException {

        List<Composer> composerResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(composerResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response retrieveAllComposersXml() throws IOException {

        List<Composer> composerResultSet = dao.getAll();
        logger.debug("slkj" + composerResultSet);
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = mapper.writeValueAsString(composerResultSet);
        logger.debug("whats this" + jsonToReturn);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/{param}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response composersOfProvidedNationalityJson(@PathParam("param") String nationality) throws JsonProcessingException {
        GenericDao localDao = new GenericDao(Nationality.class);
        int nationalityId = 0;

        // Search by property, this returns a list
        List<Nationality> nationalityList = localDao.getByPropertyEqual("nationality", nationality);
        logger.debug(nationalityList);

        //Error handling? Continue if there is only one result in the list
        if(nationalityList.size() == 1){

            // Get the id for the one returned nationality. Only expecting one, so should be at position 0.
            nationalityId = nationalityList.get(0).getId();

            // Now query for list of composers using the ID
            List<Composer> composerOfSpecificNationalityResultsSet = dao.getByPropertyEqual("nationality", nationalityId);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String output = objectMapper.writeValueAsString(composerOfSpecificNationalityResultsSet);

            return Response.status(200).entity(output).build();
        } else {
            // If no composers are returned send a nice message. Couldn't find a good error code for this,
            // not sure if an error code is even the right response. Or, should it just send back an empty json object?
            String errorMessage = "There are currently no composers with a nationality of " + nationality;
            return Response.status(200).entity(errorMessage).build();
        }

    }


    @GET
    @Path("/{param}/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response composersOfProvidedNationalityXml(@PathParam("param") String nationality) throws JsonProcessingException {
        GenericDao localDao = new GenericDao(Nationality.class);
        int nationalityId = 0;

        // Search by property, this returns a list
        List<Nationality> nationalityList = localDao.getByPropertyEqual("nationality", nationality);
        logger.debug(nationalityList);

        //Error handling? Continue if there is only one result in the list
        if(nationalityList.size() == 1){

            // Get the id for the one returned nationality. Only expecting one, so should be at position 0.
            nationalityId = nationalityList.get(0).getId();

            // Now query for list of composers using the ID
            List<Composer> composerOfSpecificNationalityResultsSet = dao.getByPropertyEqual("nationality", nationalityId);

            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String xml = mapper.writeValueAsString(composerOfSpecificNationalityResultsSet);

            return Response.status(200).entity(xml).build();
        } else {
            // If no composers are returned send a nice message. Couldn't find a good error code for this,
            // not sure if an error code is even the right response. Or, should it just send back an empty json object?
            String errorMessage = "There are currently no composers with a nationality of " + nationality;
            return Response.status(200).entity(errorMessage).build();
        }

    }


    @GET
    @Path("/turkey/{param}")
    public Response testing(@PathParam("param") String nationality){


        String output = "Hey! Check this shit out! We got something from the path and it is: " + nationality;

        return Response.status(200).entity(output).build();
    }

}
