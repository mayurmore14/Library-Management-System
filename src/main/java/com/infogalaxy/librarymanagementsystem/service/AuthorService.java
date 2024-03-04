package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.exceptions.MemberNotFoundException;
import com.infogalaxy.librarymanagementsystem.model.AuthorModel;
import com.infogalaxy.librarymanagementsystem.repo.IAuthorRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService implements IAuthorService{

    /***
     * to create object of author repo interface
     */
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
     * method to retrieve all Authors data
     * @return - List of All Authors
     */
    @Override
    public List<AuthorEntity> retrieveAllAuthors() {
        return iAuthorRepo.findAll();
    }

    /***
     * Method to Retrieve Author data by their ID
     * @param id - Used to find Author data by their ID
     * @return - Data of Author as a Object
     */
    @Override
    public Optional<AuthorEntity> retrieveAuthorById(int id) {
        Optional<AuthorEntity> authorEntity = iAuthorRepo.findById(id);
        if (authorEntity.isPresent()) {
            return authorEntity;
        } else {
            throw new MemberNotFoundException("Book with Given ID is not Found in Database");
        }

    }

    /***
     * method to update existing author data
     * @param id - Access author data by given Id from database
     * @param authorModel - object of model class containing new data for update
     * @return - updated data of author
     */
    @Override
    public AuthorEntity updateAuthorById(int id, AuthorModel authorModel) {

     AuthorEntity authorEntity = retrieveAuthorById(id).get();
     BeanUtils.copyProperties(authorModel,authorEntity);
     return iAuthorRepo.save(authorEntity);

    }

    /***
     * method to delete author's data
     * @param id - access author data by given id from database
     * @return - deletion message as string
     */
    @Override
    public String deleteAuthorById(int id) {

        AuthorEntity authorEntity = retrieveAuthorById(id).get();
        iAuthorRepo.delete(authorEntity);
        return "Author Data Deleted...";
    }


}
