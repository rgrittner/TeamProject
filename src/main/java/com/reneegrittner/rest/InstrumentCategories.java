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


@Path("/InstrumentCategories")

public class InstrumentCategories {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<InstrumentCategory> dao = new GenericDao<>(InstrumentCategory.class);

    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Response retrieveAllInstrumentCategoriesJson() throws IOException {

        List<InstrumentCategory> categoryResultSet = dao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = objectMapper.writeValueAsString(categoryResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response retrieveAllInstrumentCategoriesXml() throws IOException {

        List<InstrumentCategory> categoryResultSet = dao.getAll();

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonToReturn = mapper.writeValueAsString(categoryResultSet);
        return Response.status(200).entity(jsonToReturn).build();
    }

}

