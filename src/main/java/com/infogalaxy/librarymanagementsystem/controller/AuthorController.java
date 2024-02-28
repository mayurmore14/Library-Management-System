package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.model.AuthorModel;
import com.infogalaxy.librarymanagementsystem.responses.Responses;
import com.infogalaxy.librarymanagementsystem.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author/api")
public class AuthorController {

    @Autowired
    IAuthorService iAuthorService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Author API";
    }

    /***
     * API to create new Author
     * @param authorModel
     * @return Custom Response object with response data
     */
    @PostMapping("/createauthor")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorModel authorModel) {
        return new ResponseEntity<>(new Responses("Author Added Successfully...", HttpStatus.CREATED, iAuthorService.createAuthor(authorModel)),HttpStatus.CREATED);
    }

    /***
     * API to Retrieve All Authors Information
     * @return - Custom Response with List of Objects
     */
    @GetMapping("/retrieveallauthors")
    public ResponseEntity<?> retrieveAllAuthors() {
        return new ResponseEntity<>(new Responses("All Authors Information Retrieved successfully...", HttpStatus.FOUND, iAuthorService.retrieveAllAuthors()),HttpStatus.FOUND);
    }

}
