import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCar extends parserJSONTest {
    @Test
    public void emptyFileTest() {
        assertThrows(ParserJSON.EmptyJSONException.class,
                () -> parser.parseCar(new File("empty.json")));
        assertThrows(ParserJSON.EmptyJSONException.class,
                () -> parser.parseCar(new File("./src/test/resources/emptyJSON.json")));
    }

    @Test
    public void unstructuredFileTest(){
        assertThrows(ParserJSON.UnstructuredJSONException.class,
                () -> parser.parseCar(new File("./src/test/resources/dataUnstructured.json")));
    }

    @Test
    public void missingFieldTest(){
        assertThrows(ParserJSON.MissingFieldJSONException.class,
                () -> parser.parseCar(new File("./src/test/resources/dataCarMissingField.json")));
    }

    @Test
    public void unTreatableFieldTypeTest(){
        assertThrows(ParserJSON.UntreatableFieldTypeJSONException.class,
                () -> parser.parseCar(new File("./src/test/resources/dataCarUntreatableField.json")));
        assertThrows(ParserJSON.UntreatableFieldTypeJSONException.class,
                () -> parser.parseCar(new File("./src/test/resources/dataCarUnexpectedField.json")));
    }

    @Test
    public void serializeCarObject() {

        try {
            List<Car> cars = parser.parseCar(new File("./src/test/resources/dataCar.json"));
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

    @Test
    public void serializeCarObjects() {
        try {
            List<Car> cars = parser.parseCar(new File("./src/test/resources/dataCarMultipleObjects.json"));
            assert(!cars.isEmpty());
            assertEquals(cars.size(), 4);
            assertEquals(cars.get(0), cars.get(1));
            assertNotEquals(cars.get(3), cars.get(2));
            assertNotEquals(cars.get(3), cars.get(1));
            assertNotEquals(cars.get(3), cars.get(0));
            assertNotEquals(cars.get(2), cars.get(0));
            assertNotEquals(cars.get(2), cars.get(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
