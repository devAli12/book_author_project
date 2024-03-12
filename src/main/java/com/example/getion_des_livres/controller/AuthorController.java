package com.example.getion_des_livres.controller;

import com.example.getion_des_livres.constants.AuthorConstants;
import com.example.getion_des_livres.dto.AuthorDto;
import com.example.getion_des_livres.dto.BookDto;
import com.example.getion_des_livres.dto.ErrorResponseDto;
import com.example.getion_des_livres.dto.ResponseDto;
import com.example.getion_des_livres.entity.Author;
import com.example.getion_des_livres.service.IAuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final IAuthorService iAuthorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        List<AuthorDto> authors = iAuthorService.getAllAuthors();
        return ResponseEntity.status(HttpStatus.OK).body(authors);
    }


    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam  int id){
        iAuthorService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AuthorConstants.STATUS_200,AuthorConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Create Author REST API",
            description = "REST API to create new Author "
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
    }
    )
    @PostMapping
    public ResponseEntity<ResponseDto> create( @RequestBody  @Valid AuthorDto authorDto){
        iAuthorService.create(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AuthorConstants.STATUS_201,AuthorConstants.MESSAGE_201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable int id){
        AuthorDto authorDto = iAuthorService.getAuthor(id);
        return ResponseEntity.status(HttpStatus.OK).body(authorDto);
    }

}
