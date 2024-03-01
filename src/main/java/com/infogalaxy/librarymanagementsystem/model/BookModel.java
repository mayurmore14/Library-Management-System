package com.infogalaxy.librarymanagementsystem.model;

import lombok.Data;

@Data
public class BookModel {

    private int bookid;

    private String booktitle;

    private String bookauthorname;

    private int bookprice;

    private String bookisbn;

    private int publishyear;
}
