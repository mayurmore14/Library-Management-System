package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.model.AuthorModel;

public interface IAuthorService {

    public AuthorEntity createAuthor(AuthorModel authorModel);
}
