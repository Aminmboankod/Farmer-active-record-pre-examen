package edu.craptocraft;

import java.util.List;
import java.util.Optional;

import edu.craptocraft.entity.Farmer;
import edu.craptocraft.entity.Fruit;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceFruit {

    public ServiceFruit() {
    }

    public List<Fruit> list() {
        return Fruit.listAll();
    }

    public void add(Fruit fruit) {

        Optional<Farmer> farmer = Farmer.find("name", fruit.farmer.getName()).firstResultOptional();

        if (farmer.isPresent()) {
            fruit.farmer = farmer.get();
        } else {
            fruit.farmer.persist();
        }
        fruit.persist();

    }


}
