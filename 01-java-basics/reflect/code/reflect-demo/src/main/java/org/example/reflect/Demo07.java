package org.example.reflect;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
* 反射的简单应用：
* 根据配置文件创建类的对象，并执行方法
* */
public class Demo07 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ClassLoader cl = Demo07.class.getClassLoader();
        InputStream in = cl.getResourceAsStream("1.properties");

        Properties properties = new Properties();
        properties.load(in);

        String className = properties.getProperty("className");
        String method = properties.getProperty("method");

        Class<?> c = Class.forName(className);
        Method m = c.getMethod(method, String.class);
        Object o = c.newInstance();
        m.invoke(o, "Doe");

        System.out.println(o);//Person{name='Doe', age=0}
    }
}
