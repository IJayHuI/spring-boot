package com.example.springboot.controllers;

import com.example.springboot.Response;
import com.example.springboot.dto.DemoDto;
import com.example.springboot.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo/{id}")
    public Response<DemoDto> getDemoById(@PathVariable long id) { //路径变量
        return Response.newSuccess(demoService.getDemoById(id));
    }

    @PostMapping("/demo")
    public Response<Long> AddDemo(@RequestBody DemoDto demoDto) {
        return Response.newSuccess(demoService.AddDemo(demoDto));
    }


}
