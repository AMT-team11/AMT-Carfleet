package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Car;
import main.ParserJSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCar {

    ParserJSON parser = new ParserJSON();
    @BeforeEach
    void setUp() {
        parser = new ParserJSON();
    }
    /* test that the parser throw an exception if it receives an empty file */
    @Test
    public void emptyFileTest(){

        File file = new File("empty.json");
        assertThrows(ParserJSON.EmptyJSONException.class, () -> parser.parseCar(file));
    }

    @Test
    public void unstructuredFileTest(){
        File file = new File("/dataUnstructured.json");
        assertThrows(ParserJSON.UnstructuredJSONException.class, () -> parser.parseCar(file));
    }

    @Test
    public void missingFieldTest(){
        File file = new File("/dataMissingField.json");
        assertThrows(ParserJSON.MissingFieldJSONException.class, () -> parser.parseCar(file));
    }

    @Test
    public void unTreatableFieldTypeTest(){
        File file = new File("/dataUntreatableFieldType.json");
        assertThrows(ParserJSON.UntreatableFieldTypeJSONException.class, () -> parser.parseCar(file));
    }
    @Test
    public void serializeCarObject() {
        ParserJSON pj = new ParserJSON();
        try {
            List<Car> cars = pj.parseCar(new File("dataCar.json"));
            assert(!cars.isEmpty());
            Car car = cars.get(0);
            assert(Objects.equals(car.getId(), "939948275"));
            assert(Objects.equals(car.getName(), "GE 123201"));
            assert(car.getColumn_values().length == 33);
            assert(Objects.equals(car.getColumn_values()[0].getTitle(), "Modèle"));
            assert(Objects.equals(car.getColumn_values()[0].getText(), "Volkswagen California"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
