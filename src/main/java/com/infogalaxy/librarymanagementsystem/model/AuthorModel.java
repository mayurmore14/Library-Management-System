package com.infogalaxy.librarymanagementsystem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorModel {

    private int authorid;

    @NotBlank(message = "Please Enter Author Name")
    private String authorname;

    @NotBlank(message = "Please Enter Author City")
    private String authorcity;
}
