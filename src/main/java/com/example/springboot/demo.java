package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class demo {

    @GetMapping("/hello")
    public List<String> hello() {
        return List.of("Hello" , "World");
    }
}
