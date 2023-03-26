package com.example.librarybackend.controller;

import com.example.librarybackend.dto.AuthorDto;
import com.example.librarybackend.entity.Author;
import com.example.librarybackend.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/authors")
public class AuthorController {
    private AuthorService authorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createAuthor(@RequestBody Author author) {
        return authorService.createNewAuthor(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto updateAuthor(@RequestBody Author author, @PathVariable Long id) {
        return authorService.updateAuthor(author, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
