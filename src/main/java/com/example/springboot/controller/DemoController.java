package com.example.springboot.controller;

import com.example.springboot.dao.Demo;
import com.example.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo/{id}")
    public Demo getDemoById(@PathVariable long id) { //路径变量
        return demoService.getDemoById(id);
    }

}
