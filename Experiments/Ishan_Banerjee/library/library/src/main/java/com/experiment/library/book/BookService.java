package com.experiment.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        var bookByName = bookRepository.findBookByName(book.getName());
        if(bookByName.isPresent())
            throw new IllegalStateException("Book present");
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        var exists = bookRepository.existsById(id);
        if(!exists){ throw new IllegalStateException("Book with " + id + " not found");}
        bookRepository.deleteById(id);
    }
}
