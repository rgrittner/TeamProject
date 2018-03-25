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
public class JSONComposer {
    

    @GET
    @Produces("text/json")
    public Response getComposers(){
        GenericDao<Composer> dao = new GenericDao<>(Composer.class);
        List<Composer> composers = dao.getAll();


        return Response.status(200).entity(composers.toString()).build();
    }
}
