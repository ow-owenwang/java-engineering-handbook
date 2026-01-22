package org.example.reflect;

import org.example.domain.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 通过反射获取成员方法
 * */
public class Demo05 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> c = Person.class;

        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println(m + " >> " + m.getName());
        }

        System.out.println("===============");

        Person p = new Person();

        //获取 setName 方法
        Method setName = c.getMethod("setName", String.class);
        //执行方法
        setName.invoke(p, "Doe");
        System.out.println(p);//Person{name='Doe', age=0}
    }
}
