package nl.wilbrink.kronos.exception;

public class NotFoundException extends AppException {

    public NotFoundException(final String message) {
        this(message, null);
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(404, message, cause);
    }

}

