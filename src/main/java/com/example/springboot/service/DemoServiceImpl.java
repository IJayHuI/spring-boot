package com.example.springboot.service;

import com.example.springboot.dao.Demo;
import com.example.springboot.dao.DemoRepository;
import com.example.springboot.dto.DemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoDto getDemoById(Long id) {
        Demo demo = demoRepository.findById(id).orElseThrow(RuntimeException::new);  //不存在抛出异常
        return Response
    }


}
