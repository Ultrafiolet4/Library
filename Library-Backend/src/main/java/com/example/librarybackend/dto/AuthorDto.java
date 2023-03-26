package com.example.librarybackend.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.librarybackend.entity.Author} entity
 */
public record AuthorDto(Long id, String name, String surname, String country) implements Serializable {
}