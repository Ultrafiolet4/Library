package com.example.librarybackend.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.librarybackend.entity.Book} entity
 */
public record BookCreatingDto(String name, int year, Long authorId) implements Serializable {
}