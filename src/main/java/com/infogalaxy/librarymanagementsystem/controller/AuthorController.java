package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.model.AuthorModel;
import com.infogalaxy.librarymanagementsystem.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author/api")
public class AuthorController {

    @Autowired
    IAuthorService iAuthorService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Author API";
    }


    @PostMapping("/createauthor")
    public AuthorEntity createAuthor(@RequestBody AuthorModel authorModel) {
        return iAuthorService.createAuthor(authorModel);
    }
}
