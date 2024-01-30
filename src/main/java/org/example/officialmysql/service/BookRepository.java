package org.example.officialmysql.service;

import org.example.officialmysql.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    // Spring automatically implements this repository interface in a bean that has the same name

    Book findByName(String name);
}