package org.example.common.Object;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
* toString()：
*
* 查看某个类是否重写了 toString() 方法只需要对其任意对象进行打印，查看结果即可。
* */
public class Demo01 {
    public static void main(String[] args) {
        Person p = new Person("Doe", 20);

        //打印对象默认会调用对象的 toString() 方法。
        //当该对象所属的类没有重写 toString() 方法时，会调用 Object 的 toString() 方法
        System.out.println(p);//Person 类没有重写 toString() 方法，所以打印 org.example.common.Object.Person@1b6d3586

        Student s = new Student("Doe", 20);
        System.out.println(s);//Student 类重写了 toString() 方法，所以打印 Student{name='Doe', age=20}


        Random random = new Random();
        System.out.println(random);//没有重写 toString()

        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner);//重写了 toString()

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);//重写了 toString()
    }
}
