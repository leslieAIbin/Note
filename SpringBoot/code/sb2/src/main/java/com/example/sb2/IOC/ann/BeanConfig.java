package com.example.sb2.IOC.ann;


import com.example.sb2.IOC.xml.Animal;
import com.example.sb2.IOC.xml.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("dog")
    Animal getDog() {
        return new Dog();
    }
}
