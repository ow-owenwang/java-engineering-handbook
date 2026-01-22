package org.example.common.Arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        //int[] numbers = {1, 20, 10, 3, 7}; // 注意这里，会报错
        Integer[] numbers = {1, 20, 10, 3, 7};
        List<Integer> values = Arrays.asList(numbers);

        System.out.println(values);
        Iterator<Integer> i = values.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
