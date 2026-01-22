package org.example.oop.structure;

/**
 * 内部类访问外部类可以随意访问
 * 外部类访问内部类需要内部类对象
 *     间接方式：调用外部类方法，外部类方法再调用内部类方法
 *     直接方式：
 */
public class CarTest {
    public static void main(String[] args) {
        //间接方式
        Car car = new Car();
        car.start();

        //直接方式
        Car.Engine engine = new Car().new Engine();
        engine.start();
    }
}
