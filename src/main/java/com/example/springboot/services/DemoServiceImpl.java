package com.example.springboot.services;

import com.example.springboot.converters.DemoConverter;
import com.example.springboot.dao.Demo;
import com.example.springboot.dao.DemoRepository;
import com.example.springboot.dto.DemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoDto getDemoById(Long id) {
        Demo demo = demoRepository.findById(id).orElseThrow(RuntimeException::new); //不存在抛出异常
        return DemoConverter.convertDemoDto(demo);
    }

    @Override
    public Long AddDemo(DemoDto demoDto) {
        List<Demo> demoList = demoRepository.findByEmail(demoDto.getEmail());
        if(CollectionUtils.isEmpty(demoList)){
            throw new IllegalStateException("email" + demoDto.getEmail() + "已经被占用！");
        }
        Demo demo = demoRepository.save(DemoConverter.convertDemoDto(demoDto));
        return demo.getId();
    }


}
