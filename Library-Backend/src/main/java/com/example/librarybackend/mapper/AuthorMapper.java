package com.example.librarybackend.mapper;

import com.example.librarybackend.dto.AuthorDto;
import com.example.librarybackend.entity.Author;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Author partialUpdate(AuthorDto authorDto, @MappingTarget Author author);
}
