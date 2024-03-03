package com.infogalaxy.librarymanagementsystem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class MemberModel {

    private int memberid;

    @NotBlank(message = "Please Enter Member Name")
    private String membername;

    private long membermbno;

    @NotBlank(message = "Please Enter Member Email")
    private String memberemail;

    @NotBlank(message = "Please Enter Member City")
    private String membercity;
}
