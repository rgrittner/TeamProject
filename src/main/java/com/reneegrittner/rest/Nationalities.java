package com.reneegrittner.rest;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/Nationalities")
public class Nationalities {
    
    @Path("/json")
    @GET
    @Produces("application/json")
    public Response produceNationalitiesJSON(){
        GenericDao<Nationality> dao = new GenericDao<>(Nationality.class);
        List<Nationality> nationalities = dao.getAll();


        return Response.status(200).entity(nationalities.toString()).build();
    }


}
