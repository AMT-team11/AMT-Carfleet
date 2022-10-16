import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import Exception.ParserJSONException;

public class ParserJSON {

    public static void main(String[] args) throws ParserJSONException, IOException {
        ParserJSON parserJSON = new ParserJSON();
        parserJSON.parseCar(Paths.get("dataCar.json").toFile());
    }

    public List<Car> parseCar(File file) throws ParserJSONException, IOException {
        if(!file.exists() || file.length() == 0){
            throw new EmptyJSONException();
        }
        String json = new String(Files.readAllBytes(file.toPath()));
        return parseCar(json);
    }

    public List<Car> parseCar(String json) {
        ObjectNode node = null;
        List<Car> cars = null;
        try {
            checkJSON(json);
            checkFields(json);
            node = new ObjectMapper().readValue(json, ObjectNode.class);
            String items = node.get("data").get("boards").get(0).get("items").toString();
            cars = Arrays.asList((new ObjectMapper()).readValue(
                    items,
                    Car[].class));
            System.out.println(cars);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public List<Driver> parseDriver(File file) throws ParserJSONException, IOException {
        if(!file.exists() || file.length() == 0){
            throw new EmptyJSONException();
        }
        String json = new String(Files.readAllBytes(file.toPath()));
        return parseDriver(json);
    }

    public List<Driver> parseDriver(String json) {
        ObjectNode node = null;
        List<Driver> cars = null;
        try {
            checkJSON(json);
            checkFields(json);
            node = new ObjectMapper().readValue(json, ObjectNode.class);
            String items = node.get("data").get("boards").get(0).get("items").toString();
            cars = Arrays.asList((new ObjectMapper()).readValue(
                    items,
                    Driver[].class));
            System.out.println(cars);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    private void checkFields(String json) throws JsonProcessingException {
        ObjectNode node;
        node = new ObjectMapper().readValue(json, ObjectNode.class);
        if (!node.has("data")) {
            throw new MissingFieldJSONException();
        }
        node = node.get("data").deepCopy();
        if (!node.has("boards")) {
            throw new MissingFieldJSONException();
        }
    }

    private void checkJSON(String json) {
        try {
            ObjectNode node = new ObjectMapper().readValue(json, ObjectNode.class);

        } catch (JsonMappingException e) {
            throw new UntreatableFieldTypeJSONException();
        } catch (JsonParseException e) {
            throw new UnstructuredJSONException();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static class EmptyJSONException extends ParserJSONException {

    }

    public static class UnstructuredJSONException extends ParserJSONException {

    }

    public static class MissingFieldJSONException extends ParserJSONException {

    }

    public static class UntreatableFieldTypeJSONException extends ParserJSONException {

    }
}
