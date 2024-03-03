package com.infogalaxy.librarymanagementsystem.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookModel {

    private int bookid;

    @NotBlank(message = "Please Enter Book Title")
    private String booktitle;

    @NotBlank(message = "Please Enter Author Name")
    private String bookauthorname;

    private int bookprice;

    @NotBlank(message = "Please Enter Book ISBN")
    private String bookisbn;

    @NotNull(message = "Please Enter Book Publish Year")
    private int publishyear;
}
