package com.example.getion_des_livres.mapper;

import com.example.getion_des_livres.dto.BookDto;
import com.example.getion_des_livres.entity.Book;

public final class BookMapper {

    public static Book mapToBook(BookDto bookDto , Book book){
        book.setTitle(bookDto.getTitle());
        book.setType(bookDto.getType());
        book.setPages(bookDto.getPages());
        return book;
    }

    public static BookDto mapToBookDto(Book book , BookDto bookDto){
        bookDto.setTitle(book.getTitle());
        bookDto.setPages(book.getPages());
        bookDto.setType(book.getType());
        return bookDto;
    }

}
