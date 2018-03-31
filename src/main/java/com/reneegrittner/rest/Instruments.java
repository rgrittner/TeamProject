package com.reneegrittner.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
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


@Path("/Instruments")

public class Instruments {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);

    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveAllInstrumentsJson() throws IOException {

        List<Instrument> instrumentResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(instrumentResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response retrieveAllInstrumentsXml() throws IOException {

        List<Instrument> instrumentResultSet = dao.getAll();

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = mapper.writeValueAsString(instrumentResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/{param}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response composersOfProvidedNationalityJson(@PathParam("param") String instrumentCategory) throws JsonProcessingException {
        GenericDao localDao = new GenericDao(InstrumentCategory.class);
        int categoryId = 0;

        // Search by property, this returns a list
        List<InstrumentCategory> categoryList = localDao.getByPropertyEqual("instrumentCategory", instrumentCategory);
        logger.debug(categoryList);

        //Error handling? Continue if there is only one result in the list
        if(categoryList.size() == 1){

            // Get the id for the one returned nationality. Only expecting one, so should be at position 0.
            categoryId = categoryList.get(0).getId();

            // Now query for list of composers using the ID
            List<Instrument> instrumentOfSpecificCategoryResultsSet = dao.getByPropertyEqual("instrumentCategory", categoryId);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String output = objectMapper.writeValueAsString(instrumentOfSpecificCategoryResultsSet);

            return Response.status(200).entity(output).build();
        } else {
            // If no composers are returned send a nice message. Couldn't find a good error code for this,
            // not sure if an error code is even the right response. Or, should it just send back an empty json object?
            String errorMessage = "There are currently no instruments with a category of " + categoryList;
            return Response.status(200).entity(errorMessage).build();
        }

    }


    @GET
    @Path("/{param}/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response composersOfProvidedNationalityXml(@PathParam("param") String instrumentCategory) throws JsonProcessingException {
        GenericDao localDao = new GenericDao(InstrumentCategory.class);
        int categoryId = 0;

        // Search by property, this returns a list
        List<InstrumentCategory> categoryList = localDao.getByPropertyEqual("instrumentCategory", instrumentCategory);
        logger.debug(categoryList);

        //Error handling? Continue if there is only one result in the list
        if(categoryList.size() == 1){

            // Get the id for the one returned nationality. Only expecting one, so should be at position 0.
            categoryId = categoryList.get(0).getId();

            // Now query for list of composers using the ID
            List<Instrument> instrumentOfSpecificCategoryResultSet = dao.getByPropertyEqual("instrumentCategory", categoryId);

            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String xml = mapper.writeValueAsString(instrumentOfSpecificCategoryResultSet);

            return Response.status(200).entity(xml).build();
        } else {
            // If no composers are returned send a nice message. Couldn't find a good error code for this,
            // not sure if an error code is even the right response. Or, should it just send back an empty json object?
            String errorMessage = "There are currently no instrument with a category of " + categoryList;
            return Response.status(200).entity(errorMessage).build();
        }

    }


    @GET
    @Path("/turkey/{param}")
    public Response testing(@PathParam("param") String instrumentCategory){


        String output = "Hey! Check this shit out! We got something from the path and it is: " + instrumentCategory;

        return Response.status(200).entity(output).build();
    }

}

