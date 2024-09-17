package exceptions;

public class CustomQueueException extends RuntimeException {
    public CustomQueueException() { super("Queue is empty"); }
}