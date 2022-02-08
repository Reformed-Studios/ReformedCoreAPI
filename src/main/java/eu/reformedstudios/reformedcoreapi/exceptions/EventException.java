package eu.reformedstudios.reformedcoreapi.exceptions;

/**
 * Exception thrown when exception occurs during event execution.
 */
public class EventException extends RuntimeException {
    public EventException() {
        super();
    }

    public EventException(String message) {
        super(message);
    }

    public EventException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventException(Throwable cause) {
        super(cause);
    }
}
