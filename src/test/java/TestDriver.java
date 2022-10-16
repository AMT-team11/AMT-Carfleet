import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDriver {
    private ParserJSON parser = new ParserJSON();

    @BeforeEach
    public void SetUp() {
        parser = new ParserJSON();
    }

    @Test
    public void emptyFileTest(){
        File file = new File("./src/test/resources/empty.json");
        assertThrows(ParserJSON.EmptyJSONException.class, () -> parser.parseDriver(file));
    }

    @Test
    public void unstructuredFileTest(){
        File file = new File("./src/test/resources/dataUnstructured.json");
        assertThrows(ParserJSON.UnstructuredJSONException.class, () -> parser.parseDriver(file));
    }

    @Test
    public void missingFieldTest(){
        File file = new File("./src/test/resources/dataDriverMissingField.json");
        assertThrows(ParserJSON.MissingFieldJSONException.class, () -> parser.parseDriver(file));
    }

    @Test
    public void unTreatableFieldTypeTest(){
        File file = new File("./src/test/resources/dataDriverUntreatableField.json");
        assertThrows(ParserJSON.UntreatableFieldTypeJSONException.class, () -> parser.parseDriver(file));
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
}
