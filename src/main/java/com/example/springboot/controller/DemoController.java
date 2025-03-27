package com.example.springboot.controller;

import com.example.springboot.Response;
import com.example.springboot.dto.DemoDto;
import com.example.springboot.service.DemoService;
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

    @DeleteMapping("/demo/{id}")
    public void deleteDemoById(@PathVariable long id) {
        demoService.deleteDemoById(id);
    }

    @PutMapping("/demo/{id}")
    public Response<DemoDto> updateDemoById(@PathVariable long id, @RequestParam(required = false) String name,
                                            @RequestParam(required = false) String email) {
        return Response.newSuccess(demoService.updateDemoById(id, name, email));

    }

}
