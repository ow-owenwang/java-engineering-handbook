package org.example.reflect;

import org.example.domain.Person;

/*
 * 获取 Class 对象的方式：
 * 1. Class.forName("全类名")：将字节码文件加载进内存，返回 Class 对象。
 * 2. 类名.class：通过类名的属性 class 获取。
 * 3. 对象.getClass()：getClass() 方法是在 Object 类中定义的。
 * */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //方法一
        Class<?> c1 = Class.forName("org.example.domain.Person");
        System.out.println(c1);//class org.example.domain.Person
        System.out.println(c1.getName());//org.example.domain.Person

        //方法二
        Class<Person> c2 = Person.class;
        System.out.println(c2);//class org.example.domain.Person


        //方法三
        Person p = new Person();
        p.setName("Doe");
        p.setAge(20);

        Class<? extends Person> c3 = p.getClass();
        System.out.println(c3);//class org.example.domain.Person

        ClassLoader cl = c3.getClassLoader();
        Class<?> c4 = cl.loadClass("org.example.domain.Person");
        System.out.println(c4);//class org.example.domain.Person

        //比较
        System.out.println(c1 == c2);//true
        System.out.println(c1 == c3);//true
        System.out.println(c1 == c4);//true

    }
}
