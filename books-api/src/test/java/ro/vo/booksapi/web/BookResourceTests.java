package ro.vo.booksapi.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.vo.booksapi.service.book.BookService;
import ro.vo.booksapi.service.book.model.Book;
import ro.vo.resource.dto.BookDTO;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookResourceTests {
    @Mock
    private BookService bookService;

    @Mock
    private List<Book> books;

    @InjectMocks
    private BookResource bookResource;

    @Before
    public void setup() {
        bookResource = new BookResource(bookService, new BookConverter());
    }

    @Test
    public void testBookPost_success() {
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now())
                .notes("Interesting book")
                .build();
        final BookDTO bookDTO = new BookDTO()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(org.threeten.bp.LocalDate.now())
                .notes("Interesting book");
        when(bookService.create(any())).thenReturn(book);
        bookResource.bookPost(bookDTO);
        verify(bookService, times(1)).create(any(Book.class));
    }

    @Test
    public void testBookGet_success() {
        when(bookService.find()).thenReturn(books);
        bookResource.bookGet();
        verify(bookService, times(1)).find();
    }

    @Test
    public void testBookIdGet_success() {
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now())
                .notes("Interesting book")
                .build();
        when(bookService.lookup(1L)).thenReturn(book);
        bookResource.bookIdGet(1L);
    }

    @Test
    public void testBookIdGet_nonExistingBook_exception() {
        final Book book = Book.builder()
                .author("John Doe")
                .title("Fabulous Journey")
                .published(LocalDate.now())
                .notes("Interesting book")
                .build();
        when(bookService.lookup(1L)).thenReturn(book);
        bookResource.bookIdGet(1L);
        verify(bookService, times(1)).lookup(1L);
    }
}
