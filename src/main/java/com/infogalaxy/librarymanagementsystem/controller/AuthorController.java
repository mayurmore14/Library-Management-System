package com.infogalaxy.librarymanagementsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author/api")
public class AuthorController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to Author API";
    }
}
