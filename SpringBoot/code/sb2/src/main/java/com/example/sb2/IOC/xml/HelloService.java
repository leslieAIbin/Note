package com.example.sb2.IOC.xml;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
    private Student student;


    @Autowired
    @Qualifier("bird")
    private Animal animal;



    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String hello() {
//        return student.toString();
        return "hello";
    }

    public String hello2() {
        return animal.getName();
    }
}
