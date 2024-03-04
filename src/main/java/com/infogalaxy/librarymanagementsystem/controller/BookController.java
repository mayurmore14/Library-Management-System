package com.infogalaxy.librarymanagementsystem.controller;




import com.infogalaxy.librarymanagementsystem.model.BookModel;
import com.infogalaxy.librarymanagementsystem.responses.Responses;
import com.infogalaxy.librarymanagementsystem.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/book/api")
public class BookController {

    /***
     * to create object of book service interface
     */
    @Autowired
    IBookService iBookService;

    /***
     * API to add new book
     * @param bookModel - object of model class which is passing input data
     * @return - custom response with response object
     */
    @PostMapping("/addbook")
    public ResponseEntity<?> addBook(@RequestBody @Valid BookModel bookModel) {
        return new ResponseEntity<>(new Responses("Books Data Created Successfully",HttpStatus.CREATED, iBookService.addBook(bookModel)),HttpStatus.CREATED);
    }

    /***
     * API to retrieve all books information
     * @return - custom response with list of all objects
     */
    @GetMapping("/retrieveallbooks")
    public ResponseEntity<?> retrieveAllBooks() {
        return new ResponseEntity<>(new Responses("All Books Information Retrieved Successfully",HttpStatus.FOUND,iBookService.retrieveAllBooks()), HttpStatus.FOUND);
    }

    /***
     * API to retrieve book by book name
     * @param name - to find book data by books name
     * @return - custom response with response object
     */
    @GetMapping("/retrievebookbyname/{name}")
    public ResponseEntity<?> retrieveBookByName(@PathVariable ("name") String name) {
        return new ResponseEntity<>(new Responses( "Book's Data Retrieved Successfully", HttpStatus.ACCEPTED, iBookService.retrieveBookByName(name)),HttpStatus.ACCEPTED);
    }

    /***
     * API to retrieve book by book ID
     * @param id - to find data by book ID
     * @return - custom response with response object
     */
    @GetMapping("/retrievebookbyid/{id}")
    public ResponseEntity<?> retrieveBookById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new Responses("Data Found By Given ID",HttpStatus.FOUND,iBookService.retrieveBookById(id)),HttpStatus.FOUND);
    }

    /***
     * API to update data of existing book
     * @param id - to find data by book ID
     * @param bookModel - object of model class containing new data for update
     * @return - custom response with response object
     */
    @PutMapping("/updatebookbyid/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable ("id") int id,@RequestBody BookModel bookModel) {
        return new ResponseEntity<>(new Responses("Book's Data Updated Successfully",HttpStatus.ACCEPTED,iBookService.updateBookById(id,bookModel)),HttpStatus.ACCEPTED);
    }

    /***
     * API to delete book data
     * @param id - to find book data by given ID
     * @return - custom response with string
     */
    @DeleteMapping("/deletebookbyid/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new Responses("Book Information Deleted Successfully", HttpStatus.ACCEPTED, iBookService.deleteBookById(id)),HttpStatus.ACCEPTED);
    }
}
