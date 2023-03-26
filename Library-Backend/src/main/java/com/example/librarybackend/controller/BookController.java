package com.example.librarybackend.controller;

import com.example.librarybackend.dto.BookCreatingDto;
import com.example.librarybackend.dto.BookDto;
import com.example.librarybackend.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
@RestController
@RequestMapping(path = "/books")
public class BookController {
    private BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookCreatingDto bookCreatingDto) {
        return bookService.createNewBook(bookCreatingDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@RequestBody BookCreatingDto bookCreatingDto, @PathVariable Long id) {
        return bookService.updateBook(bookCreatingDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
