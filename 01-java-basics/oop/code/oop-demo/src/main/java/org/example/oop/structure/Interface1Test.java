package org.example.oop.structure;

/**
 * 如果接口的实现类只需要使用一次，那么可以省略实现类的实现，而是使用匿名内部类。
 *
 * 匿名内部类和匿名对象是不一样的，匿名内部类是省略了实现类，匿名对象是没有名称的对象
 */
public class Interface1Test {
    public static void main(String[] args) {
        //接口实现类测试
        Interface1Impl interface1 = new Interface1Impl();
        interface1.method1();
        interface1.method2();

        //使用匿名内部类
        Interface1 interface2 = new Interface1(){
            @Override
            public void method1() {
                System.out.println("匿名内部类 method1");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类 method2");
            }
        };
        interface2.method1();
        interface2.method2();


        //使用匿名内部类，并且省略对象名称，此时它是一个匿名对象，只能调用一个方法，如果需要调用另外一个方法，还需要创建一个匿名内部类
        new Interface1(){
            @Override
            public void method1() {
                System.out.println("匿名内部类 method1");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类 method2");
            }
        }.method1();



    }
}
