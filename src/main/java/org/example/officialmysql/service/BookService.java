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

    public Optional<Book> findByName(String title) {
        return bookRepository.findBookByName(title);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    public void save(Book book) {
        bookRepository.save(book);
        System.out.println("\nSuccessfully Saved :\t" + book);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }

}
