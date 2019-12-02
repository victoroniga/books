package ro.vo.booksapi.service.book.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ro.vo.booksapi.service.book.exception.EntityNotFoundException;
import ro.vo.booksapi.service.book.model.Book;

import java.time.LocalDate;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class BookRepositoryTests {

    private BookRepository bookRepository = new BookRepository();

    @Test
    public void testCreate_success() {
        final Book book = Book.builder()
                .author("Author")
                .title("Title")
                .published(LocalDate.now())
                .notes("Some notes")
                .build();
        final Book createdBook = bookRepository.create(book);
        assertThat(createdBook.getId()).isNotNull();
        assertThat(createdBook.getPublished()).isEqualTo(book.getPublished());
        assertThat(createdBook.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(createdBook.getNotes()).isEqualTo(book.getNotes());
        assertThat(createdBook.getTitle()).isEqualTo(book.getTitle());
    }

    @Test
    public void testCreateAndGetById_success() {
        final Book book = Book.builder()
                .author("Author")
                .title("Title")
                .published(LocalDate.now())
                .notes("Some notes")
                .build();
        final Book createdBook = bookRepository.create(book);
        final Book fetchedBook = bookRepository.lookup(book.getId());
        assertThat(fetchedBook).isEqualTo(createdBook);
    }

    @Test
    public void testCreateAndGet_oneBook_success() {
        final int initialBookCount = bookRepository.find().size();
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now())
                .notes("Interesting book")
                .build();
        bookRepository.create(book);
        final int finalBookCount = bookRepository.find().size();
        assertThat(finalBookCount).isEqualTo(initialBookCount + 1);
    }

    @Test
    public void testCreateAndGetById_twoBooks_success() {
        final int initialBookCount = bookRepository.find().size();
        final Book book1 = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now())
                .notes("Interesting book")
                .build();
        bookRepository.create(book1);
        final Book book2 = Book.builder()
                .author("Jane Doe")
                .title("Back Home")
                .published(LocalDate.now())
                .notes("Another interesting book")
                .build();
        bookRepository.create(book2);

        final int finalBookCount = bookRepository.find().size();
        assertThat(finalBookCount).isEqualTo(initialBookCount + 2);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGetById_nonExisting_exception() {
        bookRepository.lookup(new Random().nextLong());
    }
}
