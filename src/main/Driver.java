package main;

public class Driver {
    private String id;
    private String name;
    private Car[] subitems;

    public Driver() {}
    public Driver(String id, String name, Car[] cars) {
        this.id = id;
        this.name = name;
        this.subitems = cars;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Car[] getSubitems() {
        return subitems;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubitems(Car[] subitems) {
        this.subitems = subitems;
    }
}
