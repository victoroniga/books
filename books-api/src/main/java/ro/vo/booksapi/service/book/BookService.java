package ro.vo.booksapi.service.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.vo.booksapi.service.book.exception.InvalidPublishDateException;
import ro.vo.booksapi.service.book.model.Book;
import ro.vo.booksapi.service.book.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book create(final Book book) {
        // validate published date
        if (book.getPublished().isAfter(LocalDate.now())) {
            throw new InvalidPublishDateException("Publish date is later than today");
        }

        return bookRepository.create(book);
    }

    public List<Book> find() {
        return bookRepository.find();
    }

    public Book lookup(final Long id) {
        return bookRepository.lookup(id);
    }
}
