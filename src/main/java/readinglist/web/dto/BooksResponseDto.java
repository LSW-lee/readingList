package readinglist.web.dto;

import lombok.Builder;
import lombok.Getter;
import readinglist.domain.books.Books;
import readinglist.domain.readers.Readers;

@Getter
public class BooksResponseDto {
    private ReadersDto reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    @Builder
    public BooksResponseDto(Books entity) {
        this.reader = new ReadersDto(entity.getReader());
        this.isbn = entity.getIsbn();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.description = entity.getDescription();
    }
}

