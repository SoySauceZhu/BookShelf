package org.example.officialmysql.service;

import org.example.officialmysql.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// no usages
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
        System.out.println("\nSuccessfully Saved :\t" + book);
    }

    public void deleteAll(){
        bookRepository.deleteAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

}
