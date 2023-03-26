package com.example.librarybackend.serviceimpl;

import com.example.librarybackend.dto.BookCreatingDto;
import com.example.librarybackend.dto.BookDto;
import com.example.librarybackend.entity.Book;
import com.example.librarybackend.mapper.BookMapper;
import com.example.librarybackend.repository.AuthorRepository;
import com.example.librarybackend.repository.BookRepository;
import com.example.librarybackend.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;
    private AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

    @Override
    @Transactional
    public BookDto createNewBook(BookCreatingDto bookCreatingDto) {
        Book book = new Book();

        book.setName(bookCreatingDto.name());
        book.setYear(bookCreatingDto.year());
        book.setAuthor(authorRepository.findById(bookCreatingDto.authorId()).orElse(null));

        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookDto updateBook(BookCreatingDto bookCreatingDto, Long id) {
        Optional<Book> bookForUpdate = bookRepository.findById(id);

        if(bookForUpdate.isPresent()) {
            Book tempBook = bookForUpdate.get();
            setAllNullFieldsForBook(bookCreatingDto, tempBook);

            return bookMapper.toDto(bookRepository.save(tempBook));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BookDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElse(null));
    }

    private void setAllNullFieldsForBook(BookCreatingDto book, Book bookForUpdate) {
        if (book == null) {
            return;
        }

        if (book.name() != null) {
            bookForUpdate.setName(book.name());
        }
        if (book.year() != 0) {
            bookForUpdate.setYear(book.year());
        }
        if (book.authorId() != null) {
            bookForUpdate.setAuthor(authorRepository.findById(book.authorId()).orElse(null));
        }
    }
}
