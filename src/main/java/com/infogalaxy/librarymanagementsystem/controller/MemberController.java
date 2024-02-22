package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.model.MemberModel;
import com.infogalaxy.librarymanagementsystem.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @param memberModel
     * @return object of entity class
     */
    @PostMapping("/createmember")
    public MemberEntity createMember(@RequestBody MemberModel memberModel) {
        return iMemberService.createMember(memberModel);
    }

    /***
     * Creating an API for Getting all Members information
     * @return List of MemberEntities
     */
    @GetMapping("/retrieveallmembers")
    public List<MemberEntity> retrieveMember() {
        return iMemberService.retrieveMember();
    }
}
