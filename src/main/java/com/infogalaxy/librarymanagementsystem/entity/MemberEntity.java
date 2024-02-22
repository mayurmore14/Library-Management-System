package com.infogalaxy.librarymanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "memberinfo")
public class MemberEntity {
    @Id
    private int memberid;

    private String membername;

    private int membermbno;

    private String memberemail;

    private String membercity;
}
