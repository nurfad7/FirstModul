package exceptions;

public class CustomStackException extends RuntimeException {
    public CustomStackException() { super("Something went wrong with the stack"); }

    public CustomStackException(String customeMessage) {
        super(customeMessage);
    }
}