import java.io.File;
import Exception.ParserJSONException;

public class ParserJSON {

    public void parse(File file) throws EmptyJSONException{
        throw new EmptyJSONException();
    }

    class EmptyJSONException extends ParserJSONException {

    }

    class UnstructuredJSONException extends ParserJSONException {

    }

    class MissingFieldJSONException extends ParserJSONException {

    }

    class UntreatableFieldTypeJSONException extends ParserJSONException {

    }
}
