package org.example.common.StringBuilder;

/*
 * append()：支持链式调用
 * */
public class Demo02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append('A');
        sb.append(123);
        sb.append("Hello").append(true).append(200L);

        System.out.println(sb);

    }
}
