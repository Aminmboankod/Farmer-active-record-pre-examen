package edu.craptocraft;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.craptocraft.entity.Farmer;
import edu.craptocraft.entity.Fruit;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceFruit {

    public ServiceFruit() {
    }

    public Set<Fruit> list() {
        Stream<Fruit> fruits = Fruit.streamAll();
        return fruits.collect(Collectors.toSet());
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

    public void remove(String name) {
        Fruit fruit = Fruit.find("name", name).firstResult();
        fruit.delete();
    }

    public Optional<Fruit> getFruit(String name) {

        Optional<Fruit> fruitOptional = Fruit.find("name", name).firstResultOptional();
        if (fruitOptional.isPresent()) {

            return fruitOptional;
        } else {
            return fruitOptional.empty();
        }
    }


}
