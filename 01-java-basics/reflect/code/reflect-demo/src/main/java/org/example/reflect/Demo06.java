package org.example.reflect;

import org.example.domain.Person;

public class Demo06 {
    public static void main(String[] args) {
        Class<Person> c = Person.class;
        //获取类名
        String name = c.getName();
        System.out.println(name);//org.example.domain.Person
    }
}
