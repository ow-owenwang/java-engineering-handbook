package org.example.practice;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/*
 * 当主方法执行后，会自动自行被检测的所有方法(加了Check注解的方法)，判断方法是否有异常，记录到文件中。
 * */
public class Test {
    public static void main(String[] args) throws IOException {
        Calculator c = new Calculator();
        Class<? extends Calculator> cls = c.getClass();
        Method[] methods = cls.getMethods();

        int number = 0;//出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));


        for (Method method : methods) {
            //判断方法上是否有 Check 注解
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    number++;

                    bw.write(method.getName() + " 方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称:" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因:" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现 " + number + " 次异常");

        bw.flush();
        bw.close();
    }
}
