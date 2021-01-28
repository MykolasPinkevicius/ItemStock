package lt.mykolaspinkevicius.itemstock.exceptions;

public class NoItemFoundException extends RuntimeException {
    public NoItemFoundException(String message) {
        super(message);
    }
}
