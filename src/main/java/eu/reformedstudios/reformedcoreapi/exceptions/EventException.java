package eu.reformedstudios.reformedcoreapi.exceptions;

/**
 * Exception thrown when exception occurs during event execution.
 */
public class EventException extends RuntimeException {
    /**
     * Constructs the EventException
     */
    public EventException() {
        super();
    }

    /**
     * Constructs the EventException
     *
     * @param message Exception message.
     */
    public EventException(String message) {
        super(message);
    }

    /**
     * Constructs the EventException
     *
     * @param message Exception message
     * @param cause   Event causation
     */
    public EventException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs the EventException
     *
     * @param cause Event causation.
     */
    public EventException(Throwable cause) {
        super(cause);
    }
}
