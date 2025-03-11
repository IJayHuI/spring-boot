package com.example.springboot.controllers;

import com.example.springboot.dto.UserDto;
import com.example.springboot.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Test: New UserController
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserServices userServices;

//    @GetMapping

    @PostMapping
    public String addUser(@RequestBody UserDto user) {
        userServices.add(user);
        return "success";
    }
}
