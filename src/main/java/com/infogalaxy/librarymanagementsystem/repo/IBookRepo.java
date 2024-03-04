package com.infogalaxy.librarymanagementsystem.repo;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * IBookRepo interface is responsible to execute all SQL queries with the help of JpaRepository method
 */
@Repository
public interface IBookRepo extends JpaRepository<BookEntity, Integer> {
}
