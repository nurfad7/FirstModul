package exceptions;

public class CustomStackException extends RuntimeException {
    public CustomStackException() { super("Stack is empty"); }
}