package nl.wilbrink.kronos.exception;

public class AppException extends RuntimeException {

    private final int status;

    public AppException(final int status, final String message) {
        this(status, message, null);
    }

    public AppException(final int status, final String message, final Throwable cause) {
        super(message, cause);
        this.status= status;
    }

    public int getStatus() {
        return this.status;
    }

}
