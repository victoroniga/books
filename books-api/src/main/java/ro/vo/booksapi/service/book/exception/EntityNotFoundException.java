package ro.vo.booksapi.service.book.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(final String message) {
        super(message);
    }
}
