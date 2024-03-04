package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.model.AuthorModel;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {

    public AuthorEntity createAuthor(AuthorModel authorModel);

    public List<AuthorEntity> retrieveAllAuthors();

    public Optional<AuthorEntity> retrieveAuthorById(int id);

    public AuthorEntity updateAuthorById(int id, AuthorModel authorModel);

    public String deleteAuthorById(int id);

}
