package Exception;

public class ParserJSONException extends RuntimeException {
    public ParserJSONException(String message) {
        super(message);
    }

    public ParserJSONException() {
        super();
    }
}
