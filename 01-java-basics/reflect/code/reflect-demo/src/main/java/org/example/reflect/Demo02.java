package org.example.reflect;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader scl = ClassLoader.getSystemClassLoader();
        System.out.println(scl);//sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader cl = scl.getParent();
        System.out.println(cl);//sun.misc.Launcher$ExtClassLoader@1b6d3586

        ClassLoader cl1 = cl.getParent();
        System.out.println(cl1);//null

        Class<?> c1 = Class.forName("org.example.domain.Person");
        ClassLoader classLoader = c1.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
