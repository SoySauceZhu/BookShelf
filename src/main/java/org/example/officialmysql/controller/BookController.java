package org.example.officialmysql.controller;

import org.example.officialmysql.entities.Book;
import org.example.officialmysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody String addNewBook(@RequestParam String title, @RequestParam String author, @RequestParam String isbn) {
        Book n = new Book(title, isbn, author);
        bookService.save(n);
        return "\nSuccessfully Saved :\t" + n;
    }

}

