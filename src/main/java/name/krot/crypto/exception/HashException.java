package name.krot.crypto.exception;

/**
 * Возникает при любых ошибках хеширования
 */
public class HashException extends CryptException{
    public HashException() {
        super();
    }

    public HashException(String message) {
        super(message);
    }

    public HashException(String message, Throwable cause) {
        super(message, cause);
    }

    public HashException(Throwable cause) {
        super(cause);
    }
}
