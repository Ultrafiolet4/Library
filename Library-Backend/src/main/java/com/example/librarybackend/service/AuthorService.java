package com.example.librarybackend.service;

import com.example.librarybackend.dto.AuthorDto;
import com.example.librarybackend.entity.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAllAuthors();

    AuthorDto createNewAuthor(Author author);

    AuthorDto updateAuthor(Author author, Long id);

    void deleteAuthor(Long id);

    AuthorDto getAuthorById(Long id);
}
