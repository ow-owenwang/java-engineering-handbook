package org.example.datatype.typecast;

/*
 * 编译器常量优化
 * 在给变量进行赋值的时候，如果右侧的表达式当中全都是常量，没有任何变量，那么编译器 javac 将会直接将若干个常量表达式计算得到结果。
 *
 * 如：short result = 5 + 8;
 * 等号右边全都是常量，没有任何变量参与运算
 * 编译之后，得到的 .class 字节码文件当中直接就是：
 * short result = 13;
 *
 * 注意：一旦右侧有变量参与运算，就不会进行优化。
 * */
public class Demo06 {
    public static void main(String[] args) {
        short result = 5 + 8;
        System.out.println(result);
    }
}
