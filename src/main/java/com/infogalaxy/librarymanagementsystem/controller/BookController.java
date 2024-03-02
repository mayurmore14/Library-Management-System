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

    @GetMapping("/retrievebookbyname/{name}")
    public ResponseEntity<?> retrieveBookByName(@PathVariable ("name") String name) {
        return new ResponseEntity<>(new Responses( "Book's Data Retrieved Successfully", HttpStatus.ACCEPTED, iBookService.retrieveBookByName(name)),HttpStatus.ACCEPTED);
    }

    @GetMapping("/retrievebookbyid/{id}")
    public ResponseEntity<?> retrieveBookById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new Responses("Data Found By Given ID",HttpStatus.FOUND,iBookService.retrieveBookById(id)),HttpStatus.FOUND);
    }

    @PutMapping("/updatebookbyid/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable ("id") int id,@RequestBody BookModel bookModel) {
        return new ResponseEntity<>(new Responses("Book's Data Updated Successfully",HttpStatus.ACCEPTED,iBookService.updateBookById(id,bookModel)),HttpStatus.ACCEPTED);
    }
}
