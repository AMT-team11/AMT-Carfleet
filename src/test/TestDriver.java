package test;

import main.ParserJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Car;
import main.ParserJSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDriver {
    private ParserJSON parser = new ParserJSON();

    @BeforeEach
    public void SetUp() {
        parser = new ParserJSON();
    }

    @Test
    public void emptyFileTest() {
        assertThrows(ParserJSON.EmptyJSONException.class, () -> parser.parseDriver(new File("empty.json")));
    }
}
