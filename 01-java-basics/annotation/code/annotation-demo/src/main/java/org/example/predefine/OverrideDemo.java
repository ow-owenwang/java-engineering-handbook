package org.example.predefine;

/*
 * @Override：检测被该注解标注的方法是否是继承自父类(接口)的
 * */
public class OverrideDemo {

    //重写 toString 方法
    @Override
    public String toString() {
        return super.toString();
    }
}
