package edu.craptocraft;

import java.util.List;
import java.util.Set;

import edu.craptocraft.entity.Fruit;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceFruit {

    public ServiceFruit() {
    }

    public List<Fruit> list() {
        return Fruit.listAll();
    }


}
