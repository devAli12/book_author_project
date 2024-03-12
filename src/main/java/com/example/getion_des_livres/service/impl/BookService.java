package com.example.getion_des_livres.service.impl;

import com.example.getion_des_livres.dto.BookDto;
import com.example.getion_des_livres.entity.Author;
import com.example.getion_des_livres.entity.Book;
import com.example.getion_des_livres.exception.ResourceNotFoundException;
import com.example.getion_des_livres.mapper.BookMapper;
import com.example.getion_des_livres.repository.AuthorRepository;
import com.example.getion_des_livres.repository.BookRepository;
import com.example.getion_des_livres.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void addBookToAuthor(int authorId , BookDto bookDto) {
        Book book =BookMapper.mapToBook(bookDto,new Book());
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()->new ResourceNotFoundException("author","id",Integer.toString(authorId)));
        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);
    }

    @Override
    public boolean delete(int bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new ResourceNotFoundException("book","id",Integer.toString(bookId)));
        bookRepository.deleteById(bookId);
        return true;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> booksDto =new ArrayList<>();
        for (Book book:books) booksDto.add(BookMapper.mapToBookDto(book,new BookDto()));
        return booksDto;
    }

    @Override
    public BookDto getBook(int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("book","id",Integer.toString(id)));
        return BookMapper.mapToBookDto(book,new BookDto());
    }

}
