package org.example.operator;

public class Demo05 {
    public static void main(String[] args) {
        {
            int x = 1;
            int y = 1;

            if (x++ == 2 & ++y == 2) {
                x = 7;
            }
            System.out.println("x=" + x + ", y=" + y);//x=2, y=2
        }


        {
            int x = 1, y = 1;

            if (x++ == 2 && ++y == 2) {
                x = 7;
            }
            System.out.println("x=" + x + ", y=" + y); //x=2, y=1
        }

        {
            int x = 1, y = 1;

            if (x++ == 1 | ++y == 1) {
                x = 7;
            }
            System.out.println("x=" + x + ", y=" + y); //x=7, y=2
        }

        {
            int x = 1, y = 1;

            if (x++ == 1 || ++y == 1) {
                x = 7;
            }
            System.out.println("x=" + x + ", y=" + y); //x=7, y=1
        }
    }
}
