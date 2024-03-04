package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.exceptions.MemberNotFoundException;
import com.infogalaxy.librarymanagementsystem.model.BookModel;
import com.infogalaxy.librarymanagementsystem.repo.IBookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements IBookService{

    /***
     * to create object of book repo interface
     */
    @Autowired
    IBookRepo iBookRepo;


    /***
     * method to add new book
     * @param bookModel - object of model class which is passing input data
     * @return - object of book entity(Book)
     */
    @Override
    public BookEntity addBook(BookModel bookModel) {

        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookModel,bookEntity);
        return iBookRepo.save(bookEntity);
    }

    /***
     * method to retrieve all book from database
     * @return - list of all objects (Books)
     */
    @Override
    public List<BookEntity> retrieveAllBooks() {
        return iBookRepo.findAll();

    }

    /***
     * method to retrieve book by book name
      * @param name - to find related book by given title name
     * @return - object of founded Book
     */
    @Override
    public BookEntity retrieveBookByName(String name) {

        List<BookEntity> bookEntityList = retrieveAllBooks();

        for (int i=0; i< retrieveAllBooks().size(); i++) {

            if (name.equalsIgnoreCase(bookEntityList.get(i).getBooktitle())) {

                BookEntity bookEntity = bookEntityList.get(i);
                return bookEntity;
            } else {
                return null;
            }
        }
        return null;
    }

    /***
     * method to update book by book ID
     * @param id - to find related book by book ID
     * @param bookModel - object of model class containing new data for update
     * @return - updated data of book
     */
    @Override
    public BookEntity updateBookById(int id, BookModel bookModel) {

        BookEntity bookEntity = retrieveBookById(id).get();

        BeanUtils.copyProperties(bookModel,bookEntity);
        return iBookRepo.save(bookEntity);

    }

    /***
     *  method to retrieve book by book ID
     * @param id - to find related book by book ID
     * @return - object of entity class
     */
    @Override
    public  Optional<BookEntity> retrieveBookById(int id) {

        Optional<BookEntity> bookEntity = iBookRepo.findById(id);
        if (bookEntity.isPresent()) {
            return bookEntity;
        } else {
            throw new MemberNotFoundException("Data not Found With Given ID");
        }
    }

    /***
     * method to delete book by Given ID
     * @param id - to find related book by book ID
     * @return - deletion message as a string
     */
    @Override
    public String deleteBookById(int id) {
        BookEntity bookEntity = retrieveBookById(id).get();
        iBookRepo.delete(bookEntity);
        return "Book Deleted";
    }

}
