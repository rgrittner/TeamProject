package com.reneegrittner.rest;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/jsonConverter")
public class JSONConverter {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getMessage() {
        // Return a simple message
        String output = "Hello, I am output";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces("text/json")
    public Response getComposers() {
        // if query is empty return all composers
        GenericDao<Composer> dao = new GenericDao(Composer.class);
        List<Composer> composers = dao.getAll();
        String composerInfo = composers.get(0).toString();
        return Response.status(200).entity(composerInfo).build();
    }
    /*
    @GET
    @Produces("text/json")
    public Response getNationalities() {
        // if query is empty return all nationalities
    }
*/
}