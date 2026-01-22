package org.example.exception;

/*
 * 如果 finally 有 return 语句，永远返回 finally 中的结果，避免该情况。
 * */
public class Demo07 {
    public static void main(String[] args) {
        int a = get();
        System.out.println(a);
    }

    public static int get() {
        int a = 10;
        try {
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //一定会执行的代码
            return 2000;
        }

    }
}
