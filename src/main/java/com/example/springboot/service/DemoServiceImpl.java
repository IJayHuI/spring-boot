package com.example.springboot.service;

import com.example.springboot.dao.Demo;
import com.example.springboot.dao.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public Demo getDemoById(Long id) {
        return demoRepository.findById(id).orElseThrow(RuntimeException::new);  //不存在抛出异常
    }


}
