package com.example.getion_des_livres.service;

import com.example.getion_des_livres.dto.BookDto;
import com.example.getion_des_livres.entity.Book;

import java.util.List;

public interface IBookService {
    void addBookToAuthor(int authorId , BookDto bookDto);
     boolean delete(int bookId);
     List<BookDto> getAllBooks();

     BookDto getBook(int id);
}
