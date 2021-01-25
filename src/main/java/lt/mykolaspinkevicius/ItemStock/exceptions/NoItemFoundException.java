package lt.mykolaspinkevicius.ItemStock.exceptions;

public class NoItemFoundException extends RuntimeException {
    public NoItemFoundException(String message) {
        super(message);
    }
}
