package main;

import java.util.ArrayList;

public class Car {
    private String id;
    private String name;
    private ArrayList<Values> values;

    public Car(String id, String name, ArrayList<Values> values) {
        this.id = id;
        this.name = name;
        this.values = values;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Values> getValues() {
        return values;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValues(ArrayList<Values> values) {
        this.values = values;
    }
}
