package com.infogalaxy.librarymanagementsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/***
 * Interacting book Entity Class to the Database with book entity Table
 */

@Data
@Entity
@Table(name = "bookinfo")
public class BookEntity {

    @Id
    private int bookid;

    private String booktitle;

    private String bookauthorname;

    private int bookprice;

    private String bookisbn;

    private int publishyear;
}
