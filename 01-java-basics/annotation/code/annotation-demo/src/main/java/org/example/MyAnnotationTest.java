package org.example;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MyAnnotation(className = "org.example.Person", methodName = "method01")
public class MyAnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取该类的字节码文件对象
        Class<MyAnnotationTest> ma = MyAnnotationTest.class;
        //获取注解对象，其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
        public class MyAnnotationImpl implements MyAnnotation{
            public String className(){
                return "org.example.Person";
            }
            public String methodName(){
                return "method01";
            }
        }
        */
        MyAnnotation annotation = ma.getAnnotation(MyAnnotation.class);
        //获取值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class<?> clazz = Class.forName(className);
        Object o = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(o);

    }
}
