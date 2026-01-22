package org.example.datatype.typecast;

/*
* 自动类型转换（隐式）
* 当数据范围从小到大时，自动完成类型转换
* */
public class Demo01 {
    public static void main(String[] args) {
        /*
        * 变量 l 是 long 类型，赋的值100为 int 类型
        * int --> long，符合了数据范围从小到大的要求，所以自动类型转换
        * */
        long l = 100;
        System.out.println(l);//100

        //float --> double，符合从小到大的规则，自动类型转换
        double d = 2.5F;
        System.out.println(d);//2.5

        //long --> float，符合从小到大的规则，自动类型转换
        float f = 30L;
        System.out.println(f);//30.0
    }
}
