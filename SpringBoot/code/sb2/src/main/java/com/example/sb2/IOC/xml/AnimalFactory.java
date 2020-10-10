package com.example.sb2.IOC.xml;

public class AnimalFactory {
    public  Animal getAnimal(String type) {
        if("dog".equals(type)){
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
