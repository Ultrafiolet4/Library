package com.example.librarybackend.service;

import com.example.librarybackend.dto.BookCreatingDto;
import com.example.librarybackend.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    BookDto createNewBook(BookCreatingDto bookCreatingDto);

    BookDto updateBook(BookCreatingDto bookCreatingDto, Long id);

    void deleteBook(Long id);

    BookDto getBookById(Long id);
}
