package org.example.param;

public class Demo01 {
    public static void main(String[] args) {
        int add = add(1, 2, 3, 4);
        System.out.println(add);//10
    }


    public static int add(int... arr) {
        System.out.println(arr);//[I@1b6d3586，底层是一个数组
        System.out.println(arr.length);//4

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
}
