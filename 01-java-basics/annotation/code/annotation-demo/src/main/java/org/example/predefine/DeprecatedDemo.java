package org.example.predefine;

/*
 * @Deprecated：该注解标注的内容，表示已过时
 * */
public class DeprecatedDemo {
    @Deprecated
    public static void show() {
    }

    public static void main(String[] args) {
        show();//IDE 会提示方法已不推荐使用————代码提示上有中划线
    }
}
