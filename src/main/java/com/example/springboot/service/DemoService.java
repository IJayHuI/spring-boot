package com.example.springboot.service;

import com.example.springboot.dto.DemoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DemoService {

    DemoDto getDemoById(Long id);

    Page<DemoDto> getAllDemos(Pageable pageable);

    Page<DemoDto> searchDemos(String query, Pageable pageable);

    Long AddDemo(DemoDto demoDto);

    void deleteDemoById(long id);

    DemoDto updateDemoById(long id, String name, String email);


}
