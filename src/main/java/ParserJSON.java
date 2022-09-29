import java.io.File;

public class ParserJSON {

    public void parse(File file) throws EmptyJSONException{
        throw new EmptyJSONException();
    }

    class EmptyJSONException extends Exception {

    }
}
