package com.example.springboot.converter;

import com.example.springboot.dao.Demo;
import com.example.springboot.dto.DemoDto;

public class DemoConverter {

    //封装给前端（前端要显示的内容）
    public static DemoDto convertDemoDto(Demo demo) {
        DemoDto demoDto = new DemoDto();
        demoDto.setId(demo.getId());
        demoDto.setName(demo.getName());
        demoDto.setEmail(demo.getEmail());
        return demoDto;
    }

    //封装给数据库（返回的数据重新回到demo）（sava）
    public static Demo convertDemoDto(DemoDto demoDto) {
        Demo demo = new Demo();
        demoDto.setName(demoDto.getName());
        demoDto.setEmail(demoDto.getEmail());
        return demo;
    }

}
