package org.example.collection.ArrayList;

import org.example.collection.domain.Person;

import java.util.Arrays;

/*
* 数组有一个缺点：一旦创建，程序运行期间长度不可以发生改变。
* */
public class Demo01 {
    public static void main(String[] args) {
        //创建数组长度为2的数组
        Person[] array = new Person[2];

        Person p1 = new Person("A", 20);
        Person p2 = new Person("B", 20);
        Person p3 = new Person("C", 20);

        //给数组赋值
        array[0]=p1;
        array[1]=p2;
        //array[2]=p3;

        System.out.println(Arrays.toString(array));
    }
}
