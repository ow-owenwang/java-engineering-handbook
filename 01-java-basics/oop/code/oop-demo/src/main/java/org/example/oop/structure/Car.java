package org.example.oop.structure;

//外部类
public class Car {
    //外部类的成员变量
    private String carName;

    //外部类方法
    public void start() {
        new Engine().start();
    }

    //成员内部类
    public class Engine {
        //内部类方法
        public void start() {
            System.out.println("引擎启动");
        }
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
