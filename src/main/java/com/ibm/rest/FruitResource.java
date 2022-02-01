package com.ibm.rest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/fruits")
public class FruitResource {

    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Red delicious"));
        fruits.add(new Fruit("Banana", "Yellow and tropical"));
        fruits.add(new Fruit("Cherry", "Red and sour"));
        fruits.add(new Fruit("Grape", "Red and sweet"));
        fruits.add(new Fruit("Lemon", "Yellow and sour"));
        fruits.add(new Fruit("Orange", "Sweet and sour"));
        fruits.add(new Fruit("Pear", "Green and sour"));
        fruits.add(new Fruit("Strawberry", "Red and sour"));
    }

    @GET
    public Set<Fruit> list() {
        return fruits;
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    public Set<Fruit> remove(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }

}