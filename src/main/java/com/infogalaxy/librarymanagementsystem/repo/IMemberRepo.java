package com.infogalaxy.librarymanagementsystem.repo;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/***
 * IMemberRepo interface is responsible to execute all SQL queries with the help of JpaRepository method
 */
@Repository
public interface IMemberRepo extends JpaRepository<MemberEntity, Integer> {
}
