package org.example.reflect;

import org.example.domain.Person;

import java.lang.reflect.Field;

/*
 * 通过 Class 对象可以获取到类的成员变量，成员方法，构造方法，类名等有用的信息。
 *
 * */
public class Demo03 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Person> c = Person.class;

        //获取成员变量
        Field[] fields = c.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        //获取所有成员变量，不考虑修饰符
        Field[] fields1 = c.getDeclaredFields();
        for(Field f : fields1){
            System.out.println(f);
        }

        System.out.println("=====================");


        Person p = new Person();
        p.setName("Doe");
        p.setAge(20);
        p.setAddress("Beijing");

        Field name = c.getField("name");
        Object o = name.get(p);
        System.out.println(o);

        name.set(p, "Peter");
        System.out.println(p);

        Field address = c.getDeclaredField("address");
        //忽略访问权限修饰符的安全检查，暴力反射
        address.setAccessible(true);
        Object o1 = address.get(p);
        System.out.println(o1);


    }
}
