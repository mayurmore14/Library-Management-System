package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.model.AuthorModel;
import com.infogalaxy.librarymanagementsystem.repo.IAuthorRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorService implements IAuthorService{

    @Autowired
    IAuthorRepo iAuthorRepo;


    /***
     * Method to create new author
     * @param authorModel - object of new author
     * @return - object of entity class
     */
    @Override
    public AuthorEntity createAuthor(AuthorModel authorModel) {
        AuthorEntity authorEntity = new AuthorEntity();
        BeanUtils.copyProperties(authorModel,authorEntity);
        return iAuthorRepo.save(authorEntity);
    }

    /***
     * method to retrieve all members data
     * @return - List of All Authors
     */
    @Override
    public List<AuthorEntity> retrieveAllAuthors() {
        return iAuthorRepo.findAll();
    }
    
}
