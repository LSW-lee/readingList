package readinglist.service.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import readinglist.domain.books.Books;
import readinglist.domain.books.ReadingListRepository;
import readinglist.domain.readers.Readers;
import readinglist.web.dto.BooksResponseDto;
import readinglist.web.dto.BooksSaveDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BooksService {
    private final ReadingListRepository readingListRepository;

    @Transactional
    public Long save(BooksSaveDto saveDto) {
        return readingListRepository.save(saveDto.toEntity()).getId();
    }


    public List<BooksResponseDto> findByReader(Readers reader) {
        List<Books> readingList = readingListRepository.findByReader(reader);

        return readingList.stream()
                .map(BooksResponseDto::new)
                .collect(Collectors.toList());
    }
}
