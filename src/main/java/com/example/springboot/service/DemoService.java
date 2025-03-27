package com.example.springboot.service;

import com.example.springboot.dto.DemoDto;

public interface DemoService {

    DemoDto getDemoById(Long id);

    Long AddDemo(DemoDto demoDto);

    void deleteDemoById(long id);

    DemoDto updateDemoById(long id, String name, String email);
}
