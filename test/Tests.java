import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertThrows;

public class Tests {

    /* test that the parser throw an exception if it receives an empty file */
    @Test
    public void emptyFileTest(){
        ParserJSON parser = new ParserJSON();
        File file = new File("empty.json");
        assertThrows(IllegalArgumentException.class, () -> parser.parse(file));
    }
}
