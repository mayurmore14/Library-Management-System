package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.model.BookModel;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    public BookEntity addBook(BookModel bookModel);

    public List<BookEntity> retrieveAllBooks();

    public BookEntity retrieveBookByName(String name);

    public Optional<BookEntity> retrieveBookById(int id);

    public BookEntity updateBookById(int id, BookModel bookModel);

    public String deleteBookById(int id);



}
