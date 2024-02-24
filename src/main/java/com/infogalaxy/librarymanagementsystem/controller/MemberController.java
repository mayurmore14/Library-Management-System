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
     * @return - object of entity class
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

    /***
     * API to get member's information by their ID
     * @param id - find member data by given ID
     * @return object of entity
     */
    @GetMapping("/retrievememberbyid/{id}")
    public MemberEntity retrieveMemberById(@PathVariable ("id") int id) {
        return iMemberService.retrieveMemberById(id);
    }

    /***
     * API to Update existing data by using their ID
     * @param id - find member data by given ID
     * @param memberModel - object of model class containing new data for update
     * @return - updated data of member
     */
    @PutMapping("/updatememberbyid/{id}")
    public MemberEntity updateMemberById(@PathVariable ("id") int id , @RequestBody MemberModel memberModel) {
        return iMemberService.updateMemberById(id,memberModel);
    }

    /***
     * API to Delete Member Data from Database by Using their ID
     * @param id - Find member Data by given ID
     * @return - message of Deletion
     */
    @DeleteMapping("deletememberbyid/{id}")
    public String deleteMemberById(@PathVariable ("id") int id) {
        return iMemberService.deleteMemberById(id);
    }
}
