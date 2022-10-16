import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
        } catch (JsonProcessingException e) {
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

    }

    public static class UnstructuredJSONException extends ParserJSONException {

    }

    public static class MissingFieldJSONException extends ParserJSONException {

    }

    public static class UntreatableFieldTypeJSONException extends ParserJSONException {

    }
}
