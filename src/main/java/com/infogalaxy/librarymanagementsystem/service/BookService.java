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

    @Autowired
    IBookRepo iBookRepo;

    @Override
    public BookEntity addBook(BookModel bookModel) {

        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookModel,bookEntity);
        return iBookRepo.save(bookEntity);
    }

    @Override
    public List<BookEntity> retrieveAllBooks() {
        return iBookRepo.findAll();

    }

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

    @Override
    public BookEntity updateBookById(int id, BookModel bookModel) {

        BookEntity bookEntity = iBookRepo.findById(id).get();

        BeanUtils.copyProperties(bookModel,bookEntity);
        return iBookRepo.save(bookEntity);

    }

    @Override
    public  Optional<BookEntity> retrieveBookById(int id) {

        Optional<BookEntity> bookEntity = iBookRepo.findById(id);
        if (bookEntity.isPresent()) {
            return bookEntity;
        } else {
            throw new MemberNotFoundException("Data not Found With Given ID");
        }
    }

    @Override
    public String deleteBookById(int id) {
        BookEntity bookEntity = retrieveBookById(id).get();
        iBookRepo.delete(bookEntity);
        return "Book Deleted";


    }


}
