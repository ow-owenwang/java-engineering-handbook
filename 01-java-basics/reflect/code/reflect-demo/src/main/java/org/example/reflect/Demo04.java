package org.example.reflect;

import org.example.domain.Person;
import org.example.domain.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
* 通过反射获取构造函数
* */
public class Demo04 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Student> c = Student.class;
        //获取有参构造函数
        Constructor<Student> constructor = c.getConstructor(String.class, int.class);
        System.out.println(constructor);//public org.example.domain.Student(java.lang.String,int)

        Student s = constructor.newInstance("Doe", 19);
        System.out.println(s);//Student{name='Doe', age=19}

        System.out.println("=============");

        Class<Person> c1 = Person.class;
        Constructor<Person> constructor1 = c1.getConstructor();
        System.out.println(constructor1);//public org.example.domain.Person()

        Person person = constructor1.newInstance();
        System.out.println(person);//Person{name='null', age=0}


        //不获取构造函数，直接从 Class 对象上创建实例
        Person person1 = c1.newInstance();
        System.out.println(person1);//Person{name='null', age=0}
    }
}
