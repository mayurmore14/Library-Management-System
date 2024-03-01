package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.model.BookModel;
import com.infogalaxy.librarymanagementsystem.repo.IBookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


}
