import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCar {

    ParserJSON parser = new ParserJSON();
    @BeforeEach
    void setUp() {
        parser = new ParserJSON();
    }
    /* test that the parser throw an exception if it receives an empty file */
    @Test
    public void emptyFileTest() {
        File file = new File("empty.json");
        assertThrows(ParserJSON.EmptyJSONException.class, () -> parser.parseCar(file));
        File file2 = new File("./src/test/resources/emptyJSON.json");
        assertThrows(ParserJSON.EmptyJSONException.class, () -> parser.parseCar(file2));
    }

    @Test
    public void unstructuredFileTest(){
        File file = new File("./src/test/resources/dataUnstructured.json");
        assertThrows(ParserJSON.UnstructuredJSONException.class, () -> parser.parseCar(file));
    }

    @Test
    public void missingFieldTest(){
        File file = new File("./src/test/resources/dataMissingField.json");
        assertThrows(ParserJSON.MissingFieldJSONException.class, () -> parser.parseCar(file));
    }

    @Test
    public void unTreatableFieldTypeTest(){
        File file = new File("./src/test/resources/dataUntreatableFieldType.json");
        assertThrows(ParserJSON.UntreatableFieldTypeJSONException.class, () -> parser.parseCar(file));
    }
    @Test
    public void serializeCarObject() {
        ParserJSON pj = new ParserJSON();
        try {
            List<Car> cars = pj.parseCar(new File("./src/test/resources/dataCar.json"));
            assert(!cars.isEmpty());
            Car car = cars.get(0);
            assertEquals(car.getId(), "939948275");
            assertEquals(car.getName(), "GE 123201");
            assertEquals(car.getColumn_values().length, 33);
            assertEquals(car.getColumn_values()[0].getTitle(), "Modèle");
            assertEquals(car.getColumn_values()[0].getText(), "Volkswagen California");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
