package org.example.oop.final_keyword;

import java.util.List;

/**
 * 形参为 final
 */
public class FinalDemo05 {
    public void method01(final int i) {
        //i++;
        System.out.println(i);
    }

    public List<String> method02(final List<String> list) {
        list.add("A");
        return list;
    }
}
