package readinglist.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import readinglist.domain.books.Books;
import readinglist.domain.readers.Readers;

@Getter
@Setter
@NoArgsConstructor
public class BooksSaveDto {
    private Readers reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    @Builder
    public BooksSaveDto(String isbn, String title, String author, String description) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Books toEntity() {
        return Books.builder()
                .reader(reader)
                .isbn(isbn)
                .title(title)
                .author(author)
                .description(description)
                .build();
    }
}
