package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.Exception.ParserJSONException;

public class ParserJSON {

    public static void main(String[] args) throws ParserJSONException, IOException {
        ParserJSON parserJSON = new ParserJSON();
        parserJSON.parse(Paths.get("dataCar.json").toFile());
    }

    public void parse(File file) throws ParserJSONException, IOException {
        if(!file.exists() || file.length() == 0){
            throw new EmptyJSONException();
        }
        byte[] jsonData = Files.readAllBytes(file.toPath());
        ObjectMapper objectMapper = new ObjectMapper();
        if(file.getName().contains("Driver")){
            Driver driver = objectMapper.readValue(jsonData, Driver.class);
            System.out.println(driver);
        } else if(file.getName().contains("Car")){
            Car car = objectMapper.readValue(jsonData, Car.class);
            System.out.println(car);
        } else {
            throw new ParserJSONException();
        }

    }

    public class EmptyJSONException extends ParserJSONException {

    }

    public class UnstructuredJSONException extends ParserJSONException {

    }

    public class MissingFieldJSONException extends ParserJSONException {

    }

    public class UntreatableFieldTypeJSONException extends ParserJSONException {

    }
}
