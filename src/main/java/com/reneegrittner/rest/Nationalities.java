package com.reneegrittner.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
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


/**
 * The type Nationalities.
 */
@Path("/Nationalities")

public class Nationalities {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Dao.
     */
    GenericDao<Nationality> dao = new GenericDao<>(Nationality.class);

    /**
     * Retrieve all nationalities json response.
     *
     * @return the response
     * @throws IOException the io exception
     */
    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveAllNationalitiesJson() throws IOException {

        List<Nationality> categoryResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(categoryResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    /**
     * Retrieve all nationalities xml response.
     *
     * @return the response
     * @throws IOException the io exception
     */
    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response retrieveAllNationalitiesXml() throws IOException {

        List<Nationality> categoryResultSet = dao.getAll();

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = mapper.writeValueAsString(categoryResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

}

