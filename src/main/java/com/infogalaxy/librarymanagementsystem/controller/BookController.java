package com.infogalaxy.librarymanagementsystem.controller;


import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.model.BookModel;
import com.infogalaxy.librarymanagementsystem.responses.Responses;
import com.infogalaxy.librarymanagementsystem.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    IBookService iBookService;

    @PostMapping("/addbook")
    public ResponseEntity<?> addBook(@RequestBody BookModel bookModel) {
        return new ResponseEntity<>(new Responses("Books Data Created Successfully",HttpStatus.CREATED, iBookService.addBook(bookModel)),HttpStatus.CREATED);
    }

    @GetMapping("/retrieveallbooks")
    public ResponseEntity<?> retrieveAllBooks() {
        return new ResponseEntity<>(new Responses("All Books Information Retrieved Successfully",HttpStatus.FOUND,iBookService.retrieveAllBooks()), HttpStatus.FOUND);
    }
}