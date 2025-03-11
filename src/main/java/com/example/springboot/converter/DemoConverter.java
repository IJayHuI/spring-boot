package com.example.springboot.converter;

import com.example.springboot.dao.Demo;
import com.example.springboot.dto.DemoDto;

public class DemoConverter {

    public static DemoDto convertDemoDto(Demo demo) {
        DemoDto demoDto = new DemoDto();
        demoDto.setId(demo.getId());
        demoDto.setName(demo.getName());
        demoDto.setEmail(demo.getEmail());
        return demoDto;
    }

    public static Demo convertDemoDto(DemoDto demoDto) {
        Demo demo = new Demo();
        demoDto.setName(demoDto.getName());
        demoDto.setEmail(demoDto.getEmail());
        return demo;
    }

}
