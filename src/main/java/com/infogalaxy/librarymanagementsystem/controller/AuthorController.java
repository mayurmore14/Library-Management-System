package com.infogalaxy.librarymanagementsystem.controller;


import com.infogalaxy.librarymanagementsystem.model.AuthorModel;
import com.infogalaxy.librarymanagementsystem.responses.Responses;
import com.infogalaxy.librarymanagementsystem.service.IAuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /***
     * API to create new Author
     * @param authorModel
     * @return Custom Response object with response data
     */
    @PostMapping("/createauthor")
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorModel authorModel) {
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

    /***
     * API to Retrieve Author by ID
     * @param id - Find Author Data by their ID
     * @return - Custom Response object with response data
     */
    @GetMapping("/retrieveauthorbyid/{id}")
    public ResponseEntity<?> retrieveAuthorById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new Responses( "Author Data Retrieved Successfully...",HttpStatus.FOUND,iAuthorService.retrieveAuthorById(id)),HttpStatus.FOUND);
    }

    /***
     * API to Update Details of Author
     * @param id - used to find authors data
     * @param authorModel - new data of author
     * @return - Custom response Updated object with response data
     */
    @PutMapping("/updateauthorbyid/{id}")
    public ResponseEntity<?> updateAuthorById(@PathVariable ("id") int id, @RequestBody AuthorModel authorModel) {
        return new ResponseEntity<>(new Responses("Author's Data Updated Successfully...", HttpStatus.ACCEPTED, iAuthorService.updateAuthorById(id, authorModel)),HttpStatus.ACCEPTED);
    }

    /***
     * API to Delete Author Data
     * @param id - access author by given id from database
     * @return - custom response with string
     */
    @DeleteMapping("/deleteauthorbyid/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new Responses(HttpStatus.ACCEPTED, "Author's Data Deleted Successfully..."),HttpStatus.ACCEPTED);
    }

}
