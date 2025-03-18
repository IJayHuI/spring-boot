package com.example.springboot.services;

import com.example.springboot.converter.DemoConverter;
import com.example.springboot.dao.Demo;
import com.example.springboot.dao.DemoRepository;
import com.example.springboot.dto.DemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
        if(!CollectionUtils.isEmpty(demoList)){
            throw new IllegalStateException("email" + demoDto.getEmail() + "已经被占用！");
        }
        Demo demo = demoRepository.save(DemoConverter.convertToDemo(demoDto));
        return demo.getId();
    }

    @Override
    public void deleteDemoById(long id) {
        demoRepository.findById(id).orElseThrow(() ->  new IllegalArgumentException("id:" + id + "does not exist!"));
        demoRepository.deleteById(id);
    }

    @Override
    @Transactional  //声明失败回滚
    public DemoDto updateDemoById(long id, String name, String email) {
        Demo demoInDB = demoRepository.findById(id).orElseThrow(() ->  new IllegalArgumentException("id:" + id + "does not exist!"));

        if(StringUtils.hasLength(name) && !demoInDB.getName().equals(name)){
            demoInDB.setName(name);
        }
        if(StringUtils.hasLength(email) && !demoInDB.getEmail().equals(email)){
            demoInDB.setEmail(email);
        }
        Demo demo = demoRepository.save(demoInDB);
        return DemoConverter.convertDemoDto(demo);  //操作完成后，服务端要向前端返回更新的结果。直接返回 Demo 会暴露数据库结构，而返回 DemoDto 则能保持接口的稳定性和安全性。
    }


}
