package main;

import java.util.ArrayList;

public class Car {
    private String id;
    private String name;
    private Values[] column_values;

    public Car() {}
    public Car(String id, String name, Values[] column_values) {
        this.id = id;
        this.name = name;
        this.column_values = column_values;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Values[] getColumn_values() {
        return column_values;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColumn_values(Values[] column_values) {
        this.column_values = column_values;
    }

}
