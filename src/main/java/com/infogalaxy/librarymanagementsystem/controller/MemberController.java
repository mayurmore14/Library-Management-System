package com.infogalaxy.librarymanagementsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/api")
public class MemberController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to Library Management System";
    }

}
