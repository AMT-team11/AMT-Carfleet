import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import Exception.ParserJSONException;

public class ParserJSON {

    private <T> List<T> parse(String json, Class<T[]> tClass) {
        ObjectNode node = null;
        List<T> ret = null;
        try {
            node = new ObjectMapper().readValue(json, ObjectNode.class);
            if (!node.has("data")) {
                throw new MissingFieldJSONException();
            }
            node = node.get("data").deepCopy();
            if (!node.has("boards")) {
                throw new MissingFieldJSONException();
            }
            node = node.get("boards").get(0).deepCopy();
            if (!node.has("items")) {
                throw new MissingFieldJSONException();
            }
            String items = node.get("items").toString();
            ret = Arrays.asList(new ObjectMapper().readValue(items, tClass));
        } catch (UnrecognizedPropertyException e) {
            throw new UntreatableFieldTypeJSONException();
        } catch (JsonParseException e) {
            throw new UnstructuredJSONException();
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    private <T> List<T> parse(File file, Class<T[]> tClass) {
        if(!file.exists() || file.length() == 0){
            throw new EmptyJSONException();
        }
        try {
            String json = new String(Files.readAllBytes(file.toPath()));
            return parse(json, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Car> parseCar(File file) throws ParserJSONException, IOException {
        return parse(file, Car[].class);
    }

    public List<Driver> parseDriver(File file) throws ParserJSONException, IOException {
        return parse(file, Driver[].class);
    }

    public static class EmptyJSONException extends ParserJSONException {
        public EmptyJSONException() {
            super("The file is empty");
        }

    }

    public static class UnstructuredJSONException extends ParserJSONException {
        public UnstructuredJSONException() {
            super("The file could not be parsed because jackson object mapper unexpectedly reached the end of JSON input");
        }
    }

    public static class MissingFieldJSONException extends ParserJSONException {
        public MissingFieldJSONException() {
            super("The file could not be parsed because required field were missing in JSON input");
        }
    }

    public static class UntreatableFieldTypeJSONException extends ParserJSONException {
        public UntreatableFieldTypeJSONException() {
            super("The file could not be parsed because the name of a field was not recognized");
        }
    }

}
