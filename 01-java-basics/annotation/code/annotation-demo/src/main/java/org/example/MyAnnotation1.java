package org.example;

/*
 * 注解中可以定义的属性
 * */
public @interface MyAnnotation1 {
    int value();

    MyEnum e();

    MyAnnotation2 annotation2();

    String[] strArr();
}
