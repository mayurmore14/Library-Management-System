package com.infogalaxy.librarymanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authorinfo")
public class AuthorEntity {

    @Id
    private int authorid;

    private String authorname;

    private String authorcity;

}
