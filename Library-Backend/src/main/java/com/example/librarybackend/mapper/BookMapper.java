package com.example.librarybackend.mapper;

import com.example.librarybackend.dto.BookCreatingDto;
import com.example.librarybackend.dto.BookDto;
import com.example.librarybackend.entity.Book;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "authorCountry", target = "author.country")
    @Mapping(source = "authorSurname", target = "author.surname")
    @Mapping(source = "authorName", target = "author.name")
    Book toEntity(BookDto bookDto);

    @InheritInverseConfiguration(name = "toEntity")
    BookDto toDto(Book book);

    @Mapping(source = "authorId", target = "author.id")
    Book toEntity1(BookCreatingDto bookCreatingDto);

    @Mapping(source = "author.id", target = "authorId")
    BookCreatingDto toDto1(Book book);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "authorId", target = "author.id")
    Book partialUpdate(BookCreatingDto bookCreatingDto, @MappingTarget Book book);
}
