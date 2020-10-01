package com.example.sb2.service;

import com.example.sb2.bean.Demo;
import com.example.sb2.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoService {
    @Autowired
    private DemoMapper demoMapper;

    public Demo findById(Long id){
        return Optional.ofNullable(demoMapper.selectByPrimaryKey(id)).orElse(null);
    }
}
