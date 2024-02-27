package com.infogalaxy.librarymanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AuthorEntity {

    @Id
    private int authorid;

    private String authorname;

    private String authorcity;
}
