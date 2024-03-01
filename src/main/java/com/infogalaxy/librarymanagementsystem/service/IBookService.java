package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.model.BookModel;

import java.util.List;

public interface IBookService {

    public BookEntity addBook(BookModel bookModel);

    public List<BookEntity> retrieveAllBooks();

    public BookEntity retrieveBookByName(String name);
}
