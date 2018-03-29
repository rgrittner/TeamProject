package com.reneegrittner.rest;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/jsonInstrument")
public class JSONInstruments {


    @GET
    @Produces("text/json")
    public Response getInstruments(){
        GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);
        List<Instrument> Instruments = dao.getAll();

        return Response.status(200).entity(Instruments.toString()).build();
    }
}

