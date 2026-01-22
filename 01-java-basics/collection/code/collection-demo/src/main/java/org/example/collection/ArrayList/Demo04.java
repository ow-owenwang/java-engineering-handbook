package org.example.collection.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 遍历
 * */
public class Demo04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        //方法一
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //方法二
        for (String s : list) {
            System.out.println(s);
        }

        //方法三
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

    }
}
