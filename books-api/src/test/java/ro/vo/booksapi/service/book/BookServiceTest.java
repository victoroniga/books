package ro.vo.booksapi.service.book;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.vo.booksapi.service.book.exception.EntityNotFoundException;
import ro.vo.booksapi.service.book.exception.InvalidPublishDateException;
import ro.vo.booksapi.service.book.model.Book;
import ro.vo.booksapi.service.book.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private List<Book> books;

    @InjectMocks
    private BookService bookService;

    @Before
    public void setup() {
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testCreate_publishedToday_success() {
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now())
                .notes("Interesting book")
                .build();
        when(bookRepository.create(any())).thenReturn(book);
        bookService.create(book);
        verify(bookRepository, times(1)).create(book);
    }

    @Test
    public void testCreate_publishedYesterday_success() {
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now().minusDays(1))
                .notes("Interesting book")
                .build();
        when(bookRepository.create(any())).thenReturn(book);
        bookService.create(book);
        verify(bookRepository, times(1)).create(book);
    }

    @Test(expected = InvalidPublishDateException.class)
    public void testCreate_publishedTomorrow_exception() {
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now().plusDays(1))
                .notes("Interesting book")
                .build();
        bookService.create(book);
    }

    @Test
    public void testGet_success() {
        when(bookRepository.find()).thenReturn(books);
        bookService.find();
        verify(bookRepository, times(1)).find();
    }

    @Test
    public void testGetById_success() {
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now())
                .notes("Interesting book")
                .build();
        when(bookRepository.lookup(1L)).thenReturn(book);
        bookService.lookup(1L);
        verify(bookRepository, times(1)).lookup(1L);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGetById_nonExistingBook_exception() {
        when(bookRepository.lookup(1L)).thenThrow(EntityNotFoundException.class);
        bookService.lookup(1L);
    }
}
