package ro.vo.booksapi.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ro.vo.booksapi.service.book.exception.EntityNotFoundException;
import ro.vo.booksapi.service.book.exception.InvalidPublishDateException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleException(final EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HttpError(exception.getMessage()));
    }

    @ExceptionHandler({InvalidPublishDateException.class})
    public ResponseEntity<Object> handleException(final InvalidPublishDateException exception) {
        return ResponseEntity.badRequest().body(new HttpError(exception.getMessage()));
    }
}
