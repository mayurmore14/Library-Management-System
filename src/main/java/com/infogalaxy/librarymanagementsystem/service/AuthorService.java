package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.model.AuthorModel;
import com.infogalaxy.librarymanagementsystem.repo.IAuthorRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    IAuthorRepo iAuthorRepo;

    @Override
    public AuthorEntity createAuthor(AuthorModel authorModel) {
        AuthorEntity authorEntity = new AuthorEntity();
        BeanUtils.copyProperties(authorModel,authorEntity);
        return iAuthorRepo.save(authorEntity);
    }
}
