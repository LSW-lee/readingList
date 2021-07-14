package readinglist.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import readinglist.domain.books.Books;
import readinglist.domain.readers.Readers;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class ReadersDto {

    private String username;
    private String fullname;
    private String password;

    @Builder
    public ReadersDto(String username, String fullname, String password) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
    }

    public ReadersDto(Readers entity) {
        this.username = entity.getUsername();
        this.fullname = entity.getFullname();
        this.password = entity.getPassword();
    }
}
