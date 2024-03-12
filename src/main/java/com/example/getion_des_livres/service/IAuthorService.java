package com.example.getion_des_livres.service;

import com.example.getion_des_livres.dto.AuthorDto;
import com.example.getion_des_livres.dto.BookDto;
import com.example.getion_des_livres.entity.Author;

import java.util.List;

public interface IAuthorService {
    void create(AuthorDto authorDto);

    boolean delete(int authorId);

    List<AuthorDto> getAllAuthors();

    AuthorDto getAuthor(int id);

}
