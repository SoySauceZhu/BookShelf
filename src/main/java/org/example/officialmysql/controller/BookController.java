package org.example.officialmysql.controller;

import org.example.officialmysql.entities.Book;
import org.example.officialmysql.service.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    public @ResponseBody Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam Long id, @RequestParam String title) {
        Book n = new Book();
        n.setName(title);
        n.setId(id);
        bookRepository.save(n);
        return "Saved";
    }

    @GetMapping("/find")
    public Book findByName(@RequestParam String title) {
        return bookRepository.findByName(title);
    }
}

