package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/api")
public class MemberController {

    @Autowired
    IMemberService iMemberService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Library Management System";
    }

    /***
     * creating an API for Adding New Member
     * @param memberEntity
     * @return object of entity class
     */
    @PostMapping("/createmember")
    public MemberEntity createMember(@RequestBody MemberEntity memberEntity) {
        return iMemberService.createMember(memberEntity);
    }
}
