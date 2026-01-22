package org.example;
/*
* 装箱和拆箱
* */
public class IntegerDemo01 {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        System.out.println(i1);//1

        Integer i2 = new Integer("123");
        //Integer i2 = new Integer("a");//java.lang.NumberFormatException: For input string: "a"
        System.out.println(i2);//123

        Integer i3 = Integer.valueOf(1);
        System.out.println(i3);//1

        Integer i4 = Integer.valueOf("123");
        System.out.println(i4);//123


        //拆箱，在包装类中取出基本类型的数据
        int i = i4.intValue();
        System.out.println(i);
    }
}
