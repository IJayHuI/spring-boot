package com.example.springboot.services;

import com.example.springboot.dto.DemoDto;

public interface DemoService {

    DemoDto getDemoById(Long id);

    Long AddDemo(DemoDto demoDto);

}
