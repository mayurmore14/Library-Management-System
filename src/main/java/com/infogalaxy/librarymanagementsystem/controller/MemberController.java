package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.MemberEntity;
import com.infogalaxy.librarymanagementsystem.model.MemberModel;
import com.infogalaxy.librarymanagementsystem.responses.Responses;
import com.infogalaxy.librarymanagementsystem.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @param memberModel
     * @return - Custom response object with response data
     */
    @PostMapping("/createmember")
    public ResponseEntity<?> createMember(@RequestBody MemberModel memberModel) {
        return new ResponseEntity<>(new Responses("New Member Added Successfully...", HttpStatus.CREATED, iMemberService.createMember(memberModel)),HttpStatus.CREATED);
    }

    /***
     * Creating an API for Getting all Members information
     * @return custom response List of object's
     */
    @GetMapping("/retrieveallmembers")
    public ResponseEntity<?> retrieveMember() {
        return new ResponseEntity<>(new Responses (" All Member's Retrieved Successfully...",HttpStatus.FOUND, iMemberService.retrieveMember()),HttpStatus.FOUND);
    }

    /***
     * API to get member's information by their ID
     * @param id - find member data by given ID
     * @return - Custom response object with response data
     */
    @GetMapping("/retrievememberbyid/{id}")
    public ResponseEntity<?> retrieveMemberById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new Responses("Retrieved Member Successfully", HttpStatus.FOUND, iMemberService.retrieveMemberById(id)),HttpStatus.FOUND);
    }

    /***
     * API to Update existing data by using their ID
     * @param id - find member data by given ID
     * @param memberModel - object of model class containing new data for update
     * @return - Custom response Updated object with response data
     */
    @PutMapping("/updatememberbyid/{id}")
    public ResponseEntity<?> updateMemberById(@PathVariable ("id") int id , @RequestBody MemberModel memberModel) {
        return new ResponseEntity<>(new Responses("Update Member Data successfully...", HttpStatus.ACCEPTED, iMemberService.updateMemberById(id,memberModel)), HttpStatus.ACCEPTED);
    }

    /***
     * API to Delete Member Data from Database by Using their ID
     * @param id - Find member Data by given ID
     * @return - Response message of Deletion
     */
    @DeleteMapping("deletememberbyid/{id}")
    public ResponseEntity<?> deleteMemberById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new Responses(HttpStatus.ACCEPTED, iMemberService.deleteMemberById(id)),HttpStatus.ACCEPTED);
    }
}
