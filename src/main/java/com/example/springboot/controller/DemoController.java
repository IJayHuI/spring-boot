package com.example.springboot.controller;

import com.example.springboot.Response;
import com.example.springboot.dto.DemoDto;
import com.example.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo/{id}")
    public Response<DemoDto> getDemoById(@PathVariable long id) { //路径变量
        return Response.newSuccess(demoService.getDemoById(id));
    }

    @GetMapping("/demos")
    public Response<Page<DemoDto>> getDemos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String query) {

        Pageable pageable = PageRequest.of(page, size);
        return Response.newSuccess(
                StringUtils.hasText(query) ?
                        demoService.searchDemos(query, pageable) :
                        demoService.getAllDemos(pageable)
        );
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
