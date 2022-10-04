package main;

import java.util.ArrayList;

public class Driver {
    private String id;
    private String name;
    private ArrayList<Car> cars;

    public Driver(String id, String name, ArrayList<Car> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
