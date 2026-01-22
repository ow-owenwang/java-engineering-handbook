package org.example.common.Objects;

import org.example.common.domain.Person;

import java.util.Objects;

public class Demo01 {
    public static void main(String[] args) {

        //对传递过来的参数进行合法性判断，判断是否为 null
        Person p = new Person();
        double random = Math.random();
        if (random > 0.5) {
            p = null;
        }
        Object o = Objects.requireNonNull(p, "ABC");
        System.out.println(o);


    }
}
