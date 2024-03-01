package com.infogalaxy.librarymanagementsystem.controller;


import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.model.BookModel;
import com.infogalaxy.librarymanagementsystem.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    IBookService iBookService;

    @PostMapping("/addbook")
    public BookEntity addBook(@RequestBody BookModel bookModel) {
        return iBookService.addBook(bookModel);
    }
}
