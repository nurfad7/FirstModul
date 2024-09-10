package exceptions;

public class FormatColumnException extends RuntimeException {
    public FormatColumnException() {
        super("There's no column");
    }
}