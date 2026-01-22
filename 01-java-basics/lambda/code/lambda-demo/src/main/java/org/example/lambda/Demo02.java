package org.example.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("AA");
        strings.add("BB");
        strings.add("C");
        strings.add("FFF");
        boolean b = strings.removeIf(string -> string.length() == 3);
        System.out.println(b);
        System.out.println(strings);


        TreeSet<Integer> integers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        Comparator<Integer> com = Integer::compare;
        System.out.println(com.compare(30, 2));
    }
}
