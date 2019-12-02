package ro.vo.booksapi.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import ro.vo.booksapi.service.book.BookService;
import ro.vo.booksapi.service.book.model.Book;
import ro.vo.resource.BookApi;
import ro.vo.resource.dto.BookDTO;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class BookResource implements BookApi {

    private final BookService bookService;
    private final BookConverter bookConverter;

    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<BookDTO>> bookGet() {
        return ResponseEntity.ok((bookService.find()).stream().map(bookConverter::toBookDTO).collect(Collectors.toList()));
    }

    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<BookDTO> bookIdGet(final Long id) {
        return ResponseEntity.ok(bookConverter.toBookDTO(bookService.lookup(id)));
    }

    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<BookDTO> bookPost(final BookDTO bookDTO) {
        final Book book = bookConverter.fromBookDTO(bookDTO);
        return ResponseEntity.ok(bookConverter.toBookDTO(bookService.create(book)));
    }
}
