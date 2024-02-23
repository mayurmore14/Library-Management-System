package com.infogalaxy.librarymanagementsystem.model;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class MemberModel {

    private int memberid;

    private String membername;

    private long membermbno;

    private String memberemail;

    private String membercity;
}
