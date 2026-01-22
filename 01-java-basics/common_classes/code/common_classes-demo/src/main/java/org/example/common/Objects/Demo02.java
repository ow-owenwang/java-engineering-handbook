package org.example.common.Objects;

import java.util.Objects;

/*
* 在比较两个对象的时候，Object 的 equals() 方法容易抛出空指针异常，而 Objects 类中的 equals() 方法就优化了这个问题。
* */
public class Demo02 {
    public static void main(String[] args) {

        boolean b = Objects.equals(null, "");
        System.out.println(b);
    }
}
