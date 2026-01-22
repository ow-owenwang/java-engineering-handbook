package org.example.exception;

public class Demo08 {


    public static void main(String[] args) throws MyCompileTimeException {
        //test1();
        test2();
    }

    //因为是编译期异常，所以必须抛出或者捕获处理
    public static void test1() throws MyCompileTimeException {
        System.out.println("test1...");

        throw new MyCompileTimeException("我的自定义编译期异常");
    }

    //运行期异常，不用做处理
    public static void test2(){
        System.out.println("test2...");

        throw new MyRuntimeException("我的自定义运行期异常");
    }
}
