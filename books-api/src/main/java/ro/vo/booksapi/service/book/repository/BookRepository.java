package ro.vo.booksapi.service.book.repository;

import org.springframework.stereotype.Repository;
import ro.vo.booksapi.service.book.exception.EntityNotFoundException;
import ro.vo.booksapi.service.book.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

@Repository
public class BookRepository {
    private static final List<Book> books = new ArrayList<>();
    private static final Random idGenerator = new Random();

    public Book create(final Book book) {
        // generate id
        book.setId(idGenerator.nextLong());

        // persist
        books.add(book);

        return book;
    }

    public List<Book> find() {
        return new ArrayList<>(books);
    }

    public Book lookup(final Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElseThrow(() -> new EntityNotFoundException(format("Book with id %d not found", id)));
    }
}
