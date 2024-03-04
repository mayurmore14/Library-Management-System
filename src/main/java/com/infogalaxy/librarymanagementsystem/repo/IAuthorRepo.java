package com.infogalaxy.librarymanagementsystem.repo;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * IAuthorRepo interface is responsible to execute all sql query with the help of JpaRepository method
 */
@Repository
public interface IAuthorRepo extends JpaRepository<AuthorEntity,Integer> {
}
