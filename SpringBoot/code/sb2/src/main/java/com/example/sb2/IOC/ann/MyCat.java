package com.example.sb2.IOC.ann;

import com.example.sb2.IOC.xml.Animal;
import com.example.sb2.IOC.xml.Cat;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("mycat")
public class MyCat implements FactoryBean<Animal> {
    @Override
    public Animal getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}
