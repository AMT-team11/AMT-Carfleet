import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserJSONTest {

    ParserJSON parser = new ParserJSON();
    @BeforeEach
    void setUp() {
        parser = new ParserJSON();
    }
    /* test that the parser throw an exception if it receives an empty file */
    @Test
    public void emptyFileTest(){

        File file = new File("empty.json");
        assertThrows(ParserJSON.EmptyJSONException.class, () -> parser.parse(file));
    }
}
