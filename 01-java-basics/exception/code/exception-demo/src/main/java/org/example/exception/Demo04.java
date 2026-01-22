package org.example.exception;

import java.util.ArrayList;
import java.util.List;

/*
多个异常使用捕获又该如何处理呢？
1. 多个异常分别处理。
2. 多个异常一次捕获，多次处理。
3. 多个异常一次捕获一次处理。

以下示例是运行时异常，开发中不用处理，即不捕获也不声明抛出，此处仅仅是为了演示异常处理。

*/
public class Demo04 {
    public static void main(String[] args) {

        //多个异常分别处理。
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.get(10);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        //多个异常一次捕获，多次处理。
        //一个 try 多个 catch 注意事项：catch 里边定义的异常变量，如果有子父类关系，那么子类的异常变量必须写在上边，否则就会报错
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[4]);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.get(10);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        //多个异常一次捕获一次处理。
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[4]);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.get(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
