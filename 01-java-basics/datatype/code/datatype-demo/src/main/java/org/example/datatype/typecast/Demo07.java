package org.example.datatype.typecast;

public class Demo07 {
    public static void main(String[] args) {
        byte b = 127;
        int i = 150;
        float f = 452.12f;
        char c = 10;
        double d = 45.46546;

        System.out.println(b + f);//579.12
        System.out.println(b * i);//19050
        System.out.println(b / c);//12
        System.out.println(d + c);//55.46546
    }
}
