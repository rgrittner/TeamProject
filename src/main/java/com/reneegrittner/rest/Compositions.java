package com.reneegrittner.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.reneegrittner.entity.Composition;
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
 * The type Compositions.
 */
@Path("/Compositions")

public class Compositions {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Dao.
     */
    GenericDao<Composition> dao = new GenericDao<>(Composition.class);

    /**
     * Retrieve all compositions json response.
     *
     * @return the response
     * @throws IOException the io exception
     */
    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveAllCompositionsJson() throws IOException {

        List<Composition> compositionsResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(compositionsResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    /**
     * Retrieve all compositions xml response.
     *
     * @return the response
     * @throws IOException the io exception
     */
    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response retrieveAllCompositionsXml() throws IOException {

        List<Composition> compositionsResultSet = dao.getAll();
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = mapper.writeValueAsString(compositionsResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    /**
     * Retrieve compositions by title json response.
     *
     * @param title the title
     * @return the response
     * @throws JsonProcessingException the json processing exception
     */
    @GET
    @Path("/title/{title}/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveCompositionsByTitleJson(@PathParam("title") String title) throws JsonProcessingException {

        List<Composition> compositionsByTitleResultSet = dao.getByPropertyEqual("title", title);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(compositionsByTitleResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    /**
     * Retrieve compositions by title xml response.
     *
     * @param title the title
     * @return the response
     * @throws JsonProcessingException the json processing exception
     */
    @GET
    @Path("/title/{title}/xml")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveCompositionsByTitleXml(@PathParam("title") String title) throws JsonProcessingException {

        List<Composition> compositionsResultSet = dao.getByPropertyEqual("title", title);

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xmlToReturn = mapper.writeValueAsString(compositionsResultSet);
        return Response.status(200).entity(xmlToReturn).build();
    }
}
