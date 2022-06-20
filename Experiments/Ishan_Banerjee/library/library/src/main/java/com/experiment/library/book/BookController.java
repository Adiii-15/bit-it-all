package com.experiment.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBook() {
        return bookService.getBook();
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book)
    {
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookID}")
    public void deleteBook(@PathVariable("bookID") Long id)
    {
        bookService.deleteBook(id);
    }
}
