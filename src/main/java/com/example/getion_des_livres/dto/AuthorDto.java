package com.example.getion_des_livres.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class AuthorDto {
    @NotEmpty(message = "name should not empty or null")
    @Size(min = 6 ,message = "the length of the name should greater than 5")
    private String name;

    @NotEmpty(message = "numeroCertaficat should not empty or null")
    @Size(min = 6 ,message = "the length of the numeroCertaficat should greater than 5")
    private String numeroCertaficat;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
