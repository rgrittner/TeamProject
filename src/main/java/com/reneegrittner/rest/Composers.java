package com.reneegrittner.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@Path("/Composers")

public class Composers {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @GET
    public Response retrieveAllComposers() throws IOException {
        GenericDao<Composer> dao = new GenericDao<>(Composer.class);
        List<Composer> composerResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(composerResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/{param}")

    public Response composersOfProvidedNationality(@PathParam("param") String nationality){


        String output = "Hey! Check this shit out! We got something from the path and it is: " + nationality;

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/turkey/{param}")
    public Response testing(@PathParam("param") String nationality){


        String output = "Hey! Check this shit out! We got something from the path and it is: " + nationality;

        return Response.status(200).entity(output).build();
    }

}
