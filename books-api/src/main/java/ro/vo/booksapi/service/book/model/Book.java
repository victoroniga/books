package ro.vo.booksapi.service.book.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
public class Book {

    private Long id;
    private String author;
    private String title;
    private LocalDate published;
    private String notes;

    public void setId(long id) {
        this.id = id;
    }
}
