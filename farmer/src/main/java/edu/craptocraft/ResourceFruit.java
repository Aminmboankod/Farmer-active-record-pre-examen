package edu.craptocraft;



import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.Set;
import edu.craptocraft.entity.Fruit;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Fruit> add(@Valid Fruit fruit){
        service.add(fruit);
        return this.list();
    }



    @DELETE
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Fruit> remove(@Valid Fruit fruit){
        service.remove(fruit.getName());
        return this.list();
    }

}
