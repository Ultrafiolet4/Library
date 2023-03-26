package com.example.librarybackend.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.librarybackend.entity.Book} entity
 */
public record BookDto(Long id, String name, int year, String authorName, String authorSurname,
                      String authorCountry) implements Serializable {
}