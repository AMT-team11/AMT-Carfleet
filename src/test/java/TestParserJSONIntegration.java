import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestParserJSONIntegration {

    TestCar carTester = new TestCar();
    TestDriver driverTester = new TestDriver();

    @BeforeEach
    void setUp() {
        carTester.setUp();
        driverTester.setUp();
    }

    @Test
    public void encounteringMultipleExceptionsBeforeParsing() {

        carTester.emptyFileTest();
        carTester.unstructuredFileTest();
        carTester.missingFieldTest();
        carTester.unTreatableFieldTypeTest();
        carTester.serializeCarObject();

        driverTester.emptyFileTest();
        driverTester.unstructuredFileTest();
        driverTester.missingFieldTest();
        driverTester.unTreatableFieldTypeTest();
        driverTester.serializeDriverObjects();
    }

    @Test
    public void mergingFilesTest() {
try {
            List<Car> cars = carTester.parser.parseCar(new File("./src/test/resources/dataCar.json"));
            List<Driver> drivers = driverTester.parser.parseDriver(new File("./src/test/resources/dataDriver.json"));
            assert(!cars.isEmpty());
            assert(!drivers.isEmpty());

            cars.addAll(carTester.parser.parseCar(new File("./src/test/resources/dataCarMultipleObjects.json")));
            drivers.addAll(driverTester.parser.parseDriver(new File("./src/test/resources/dataDriverMultipleObjects.json")));

            assertEquals(cars.size(), 5);
            assertEquals(drivers.size(), 6);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
