package edu.craptocraft;



import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.craptocraft.entity.Fruit;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


@Path("/fruits")
public class ResourceFruit {
    
    public ResourceFruit() {
    }



    @Inject
    ServiceFruit service;

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Colmados Farmer Rick";
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Fruit> list(){
        return service.list();
    }

}
