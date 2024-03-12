package com.example.getion_des_livres.mapper;

import com.example.getion_des_livres.dto.AuthorDto;
import com.example.getion_des_livres.entity.Author;

public final class AuthorMapper{

    public  static Author mapToAuthor(AuthorDto authorDto, Author author){
        //Author author1 = Author.builder()
              //  .name(authorDto.getName())
                        //.birthDate(authorDto.getBirthDate())
                             //  .numCertaficat(author.getNumCertaficat())
                               //       .build();
        author.setName(authorDto.getName());
        author.setBirthDate(authorDto.getBirthDate());
        author.setNumCertaficat(authorDto.getNumeroCertaficat());
        return author;
    }

    public static AuthorDto mapToAuthorDto(Author author, AuthorDto authorDto){
        authorDto.setName(author.getName());
        authorDto.setBirthDate(author.getBirthDate());
        authorDto.setNumeroCertaficat(author.getNumCertaficat());
        return authorDto;
    }

}
