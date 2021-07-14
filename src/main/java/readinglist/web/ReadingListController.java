package readinglist.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import readinglist.domain.readers.Readers;
import readinglist.service.books.BooksService;
import readinglist.web.dto.BooksResponseDto;
import readinglist.web.dto.BooksSaveDto;
import readinglist.web.dto.ReadersDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ReadingListController {
    private static final String reader = "craig";

    private final BooksService booksService;
    //private ReadingListRepository readingListRepository;

    @RequestMapping(method = RequestMethod.GET)
    //@GetMapping
    public String readersBooks(Readers reader, Model model) {
        List<BooksResponseDto> readingList = booksService.findByReader(reader);
        if(readingList.size() != 0) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", new ReadersDto(reader));
        }

        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Readers reader, BooksSaveDto booksSaveDto) {
        booksSaveDto.setReader(reader);
        booksService.save(booksSaveDto);
        return "redirect:/";
    }

}
