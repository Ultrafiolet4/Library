package com.example.librarybackend.serviceimpl;

import com.example.librarybackend.dto.AuthorDto;
import com.example.librarybackend.entity.Author;
import com.example.librarybackend.mapper.AuthorMapper;
import com.example.librarybackend.repository.AuthorRepository;
import com.example.librarybackend.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::toDto).toList();
    }

    @Override
    @Transactional
    public AuthorDto createNewAuthor(Author author) {
        return authorMapper.toDto(authorRepository.save(author));
    }

    @Override
    @Transactional
    public AuthorDto updateAuthor(Author author, Long id) {
        Optional<Author> authorForUpdate = authorRepository.findById(id);

        if (authorForUpdate.isPresent()) {
            Author tempAuthor = authorForUpdate.get();

            setAllNullFieldsForAuthor(author, tempAuthor);

            return authorMapper.toDto(authorRepository.save(tempAuthor));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public AuthorDto getAuthorById(Long id) {
        return authorMapper.toDto(authorRepository.findById(id).orElse(null));
    }

    private void setAllNullFieldsForAuthor(Author author, Author authorForUpdate) {
        if (author == null) {
            return;
        }

        if (author.getName() != null) {
            authorForUpdate.setName(author.getName());
        }
        if (author.getSurname() != null) {
            authorForUpdate.setSurname(author.getSurname());
        }
        if (author.getCountry() != null) {
            authorForUpdate.setCountry(author.getCountry());
        }
    }
}
