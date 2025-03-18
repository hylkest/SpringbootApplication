package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("Spring Boot in Action", "Craig Walls"));
        books.add(new Book("Clean Code", "Robert C. Martin"));
        books.add(new Book("Effective Java", "Joshua Bloch"));
    }

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully!";
    }
}
