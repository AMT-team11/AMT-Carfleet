import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestDriver extends parserJSONTest {

    @Test
    public void emptyFileTest(){
        assertThrows(ParserJSON.EmptyJSONException.class,
                () -> parser.parseDriver(new File("./src/test/resources/empty.json")));
    }

    @Test
    public void unstructuredFileTest(){
        assertThrows(ParserJSON.UnstructuredJSONException.class,
                () -> parser.parseDriver(new File("./src/test/resources/dataUnstructured.json")));
    }

    @Test
    public void missingFieldTest(){
        assertThrows(ParserJSON.MissingFieldJSONException.class,
                () -> parser.parseDriver(new File("./src/test/resources/dataDriverMissingField.json")));
    }

    @Test
    public void unTreatableFieldTypeTest(){
        assertThrows(ParserJSON.UntreatableFieldTypeJSONException.class,
                () -> parser.parseDriver(new File("./src/test/resources/dataDriverUntreatableField.json")));
        assertThrows(ParserJSON.UntreatableFieldTypeJSONException.class,
                () -> parser.parseDriver(new File("./src/test/resources/dataDriverUnexpectedField.json")));
    }

    @Test
    public void serializeDriverObject() {
        ParserJSON pj = new ParserJSON();
        try {
            List<Driver> drivers = pj.parseDriver(new File("./src/test/resources/dataDriver.json"));
            assert(!drivers.isEmpty());
            Driver driver = drivers.get(0);
            assertEquals(driver.getId(), "939948325");
            assertEquals(driver.getName(), "GE 4567889");
            assertEquals(driver.getSubitems().length,  1);
            assertEquals(driver.getSubitems()[0].getId(), "1879863460");
            assertEquals(driver.getSubitems()[0].getName(), "Responsable véhicule : Maxime Fontaines");
            assertEquals(driver.getSubitems()[0].getColumn_values().length, 9);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void serializeDriverObjects() {
        try {
            List<Driver> drivers = parser.parseDriver(new File("./src/test/resources/dataDriverMultipleObjects.json"));
            assert(!drivers.isEmpty());
            assertEquals(drivers.size(), 5);
            assertEquals(drivers.get(0), drivers.get(3));
            assertEquals(drivers.get(2), drivers.get(4));
            assertNotEquals(drivers.get(0), drivers.get(1));
            assertNotEquals(drivers.get(0), drivers.get(4));
            assertNotEquals(drivers.get(2), drivers.get(3));
            assertNotEquals(drivers.get(1), drivers.get(2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
