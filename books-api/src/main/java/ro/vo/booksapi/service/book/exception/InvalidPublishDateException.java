package ro.vo.booksapi.service.book.exception;

public class InvalidPublishDateException extends RuntimeException {
    public InvalidPublishDateException(final String message) {
        super(message);
    }
}
