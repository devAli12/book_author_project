package com.example.getion_des_livres.controller;


import com.example.getion_des_livres.constants.BookConstants;
import com.example.getion_des_livres.dto.BookDto;
import com.example.getion_des_livres.dto.ResponseDto;
import com.example.getion_des_livres.service.IBookService;
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
@RequestMapping("/books")
@Validated
public class BookController {

    private final IBookService iBookService;


    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> booksDto = iBookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(booksDto);
    }


    @DeleteMapping
    public ResponseEntity<ResponseDto> delete(@RequestParam  int id){
       iBookService.delete(id);
       return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(BookConstants.STATUS_200,BookConstants.MESSAGE_200));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addBook(int authorId ,@Valid @RequestBody BookDto bookDto){
          iBookService.addBookToAuthor(authorId,bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(BookConstants.STATUS_201,BookConstants.MESSAGE_201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable  int id){
        BookDto bookDto = iBookService.getBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }
}
