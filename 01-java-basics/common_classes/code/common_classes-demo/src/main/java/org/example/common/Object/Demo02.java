package org.example.common.Object;

/*
* equals()：
* 通过查看 Object 类的 equals() 方法源码发现，此方法是比较两个对象是否相等，基本类型比较值，引用类型比较内存地址
*
* 当我们需要重写 equals() 方法时，可以自定义比较规则，比如我们重写 Student 类的 equals() 方法，只要名字和年龄相等就相等，而不是比较内存地址。
* */
public class Demo02 {
    public static void main(String[] args) {
        Student s1 = new Student("Doe", 20);
        Student s2 = new Student("Doe", 20);

        System.out.println(s1.equals(s2));//没有重写 equals()，返回 false。重写后返回 true




    }
}
