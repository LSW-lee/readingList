package readinglist.domain.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import readinglist.domain.readers.Readers;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Books, Long> {
    List<Books> findByReader(Readers reader);
}
