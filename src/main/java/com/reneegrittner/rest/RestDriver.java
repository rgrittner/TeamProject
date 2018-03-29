package com.reneegrittner.rest;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/services")



public class RestDriver extends Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(Composers.class );
        h.add(Nationalities.class);
        h.add(Instruments.class);
        h.add(InstrumentCategory.class);

        return h;
    }

}


