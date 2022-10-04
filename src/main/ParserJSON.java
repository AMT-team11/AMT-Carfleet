package main;

import java.io.File;
import main.Exception.ParserJSONException;

public class ParserJSON {

    public void parse(File file) throws EmptyJSONException{
        throw new EmptyJSONException();
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
