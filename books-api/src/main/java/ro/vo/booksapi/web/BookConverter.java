package ro.vo.booksapi.web;

import org.springframework.stereotype.Component;
import org.threeten.bp.LocalDate;
import ro.vo.booksapi.service.book.model.Book;
import ro.vo.resource.dto.BookDTO;

@Component
class BookConverter {
    BookDTO toBookDTO(final Book book) {
        return new BookDTO()
                .author(book.getAuthor())
                .notes(book.getNotes())
                .published(LocalDate.ofEpochDay(book.getPublished().toEpochDay()))
                .title(book.getTitle())
                .id(book.getId());
    }

    Book fromBookDTO(final BookDTO bookDTO) {
        return Book.builder()
                .author(bookDTO.getAuthor())
                .notes(bookDTO.getNotes())
                .published(java.time.LocalDate.ofEpochDay(bookDTO.getPublished().toEpochDay()))
                .title(bookDTO.getTitle())
                .id(bookDTO.getId())
                .build();
    }
}
