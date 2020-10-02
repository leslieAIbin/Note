package com.example.sb2.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.*;


// 定义Spring IOC容器中Bean的执行顺序的优先级，而不是定义Bean的加载顺序
@Order(1)
public class FirstInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 获得环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String,Object> map = new HashMap<>();
        map.put("key1", "value1");
        // map打包成一个属性
        MapPropertySource mapPropertySource = new MapPropertySource("firstInitializer", map);
        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("******** Run FirstInitializer ******** ");
    }
}
