package readinglist.domain.books;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import readinglist.domain.readers.Readers;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Readers reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    @Builder
    public Books(Readers reader, String isbn, String title, String author, String description) {
        this.reader = reader;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
    }
    /*
    public Long getId() {
        return this.id;
    }

    public String getReader() {
        return this.reader;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }
    public String getDescription() {
        return this.description;
    }
    */
}
