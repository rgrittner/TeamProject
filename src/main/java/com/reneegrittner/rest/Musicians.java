package com.reneegrittner.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Musician;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/Musicians")
public class Musicians {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<Musician> dao = new GenericDao<>(Musician.class);
    @GET
    public Response retrieveAllMusicians() throws IOException {

        List<Musician> musicianResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(musicianResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/email/missing")
    public Response musiciansWhoDoNotHaveAnEmailAddress() throws JsonProcessingException {
        List<Musician> musicianResultSet = dao.getByPropertyEqual("email", "");
        logger.debug("Musicians with  no email: " + musicianResultSet);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(musicianResultSet);
        return Response.status(200).entity(jsonToReturn).build();

        

    }


}
