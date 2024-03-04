package com.infogalaxy.librarymanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/***
 * Interacting Author Entity Class to the Database with author entity Table
 */

@Data
@Entity
@Table(name = "authorinfo")
public class AuthorEntity {

    @Id
    private int authorid;

    private String authorname;

    private String authorcity;


}
