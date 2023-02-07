package name.krot.crypto.exception;

public class ResorceNotFoundException extends RuntimeException {
    public ResorceNotFoundException() {
        super();
    }

    public ResorceNotFoundException(String message) {
        super(message);
    }

    public ResorceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResorceNotFoundException(Throwable cause) {
        super(cause);
    }
}
