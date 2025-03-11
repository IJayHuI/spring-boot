package com.example.springboot.Service;

import com.example.springboot.Dao.Demo;
import com.example.springboot.Dao.DemoRepository;
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
