package ro.vo.booksapi.web;

public class HttpError {
    private String message;

    HttpError(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
