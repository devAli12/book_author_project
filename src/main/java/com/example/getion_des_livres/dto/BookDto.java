package com.example.getion_des_livres.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class BookDto {
    @NotEmpty(message = "name should not be empty or null")
    @Size(min = 6 ,message = "the length of the title should greater than 5")
    private String title;

    @NotEmpty(message = "type should not be empty or null")
    private String type;

    private int pages;

}
