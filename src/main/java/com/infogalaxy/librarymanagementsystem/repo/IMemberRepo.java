package com.infogalaxy.librarymanagementsystem.repo;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepo extends JpaRepository<MemberEntity, Integer> {
}
