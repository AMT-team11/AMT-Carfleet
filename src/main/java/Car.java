import java.util.ArrayList;
import java.util.Arrays;

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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Values v : column_values) {
            sb.append(v.toString());
            sb.append(" ");
        }
        return "Car [id=" + id + ", name=" + name + ", column_values=" + sb + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Car car)) {
            return false;
        }
        return car.getId().equals(id) && car.getName().equals(name) && Arrays.equals(car.getColumn_values(), column_values);
    }

}
