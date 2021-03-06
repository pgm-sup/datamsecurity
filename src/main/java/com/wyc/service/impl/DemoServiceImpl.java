package com.wyc.service.impl;

import com.wyc.entity.Demo;
import com.wyc.mapper.DemoMapper;
import com.wyc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "demoServie")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> getDemos() {
        return demoMapper.getDemos();
    }
}
