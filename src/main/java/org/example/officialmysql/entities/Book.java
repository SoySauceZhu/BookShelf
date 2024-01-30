package org.example.officialmysql.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // Hibernate will automatically translate entity Book to a table
@Table(name = "Book_db")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String isbn;
    private String author;

    public Book(Long id, String name, String isbn, String author) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }

    public Book(String name, String isbn, String author) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }

    public Book() {
    }

}

