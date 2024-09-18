package exceptions;

public class CustomQueueException extends RuntimeException {
    public CustomQueueException() { super("Something went wrong with the queue"); }

    public CustomQueueException(String customMessage) {
        super(customMessage);
    }
}