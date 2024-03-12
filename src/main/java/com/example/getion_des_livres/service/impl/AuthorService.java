package com.example.getion_des_livres.service.impl;

import com.example.getion_des_livres.dto.AuthorDto;
import com.example.getion_des_livres.dto.BookDto;
import com.example.getion_des_livres.entity.Author;
import com.example.getion_des_livres.entity.Book;
import com.example.getion_des_livres.exception.ResourceNotFoundException;
import com.example.getion_des_livres.mapper.AuthorMapper;
import com.example.getion_des_livres.mapper.BookMapper;
import com.example.getion_des_livres.repository.AuthorRepository;
import com.example.getion_des_livres.service.IAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @AllArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    @Override

    public void create(AuthorDto authorDto) {
       Author author= AuthorMapper.mapToAuthor(authorDto,new Author());
        authorRepository.save(author);
    }

    @Override
    public boolean delete(int authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()->new ResourceNotFoundException("author","authorId",Integer.toString(authorId)));
        authorRepository.delete(author);
        return true;
    }



    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors= authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author:authors)authorDtos.add(AuthorMapper.mapToAuthorDto(author,new AuthorDto()));
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthor(int id) {
        Author author= authorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("author","id",Integer.toString(id)));
        return AuthorMapper.mapToAuthorDto(author,new AuthorDto());
    }


}
