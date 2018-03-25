package com.reneegrittner.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/JSONConverter")
public class JSONConverter {
    // The Java method will process HTTP GET requests

    //Define what type of request this method responds to
    @GET
    //Define what type of content is produced
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getMessage() {
        // Return a simple message
        String output = "Hello Everyone!";
        return Response.status(200).entity(output).build();
    }

}
