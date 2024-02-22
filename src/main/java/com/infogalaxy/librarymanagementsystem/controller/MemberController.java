package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/api")
public class MemberController {

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
        MemberService memberService = new MemberService();
        return memberService.createMember(memberEntity);
    }
}
