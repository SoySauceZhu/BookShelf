package org.example.officialmysql.controller;

import org.example.officialmysql.entities.Book;
import org.example.officialmysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping("/add")
    public String addNewBook(@RequestParam String title, @RequestParam String author, @RequestParam String isbn) {
        // Restful controller automatically declares as @ResponseBody, to serialize response into json
        Book n = new Book(title, isbn, author);
        bookService.save(n);
        return "\nSuccessfully Saved :\t" + n;
    }

    @PostMapping("/addBook")
    public String addNewBook(@RequestBody Book book) {
        // Requires a JSON like post request
        bookService.save(book);
        return "\nSuccessfully Saved :\t" + book;
    }

    @GetMapping("/book")
    public Optional<Book> findByName(@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String isbn) {
        if (title.isEmpty()) {
            return bookService.findByIsbn(isbn);
        } else if (isbn.isEmpty()) {
            return bookService.findByName(title);
        }
        return bookService.findByName(title);
    }


    @GetMapping("/book/{isbn}")
    public Optional<Book> findByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }


    @DeleteMapping("/deleteAll")
    public String deleteAllBook() {
        // Delete all books but the sequence will not be reset
        bookService.deleteAll();
        System.out.println("Successfully delete all books");
        return "Successfully delete all books";
    }


}

