import domain.GenericWildcard;

import java.util.ArrayList;

public class Demo05 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("A");

        GenericWildcard gw = new GenericWildcard();
        gw.method(list1);//[1]
        gw.method(list2);//[A]
    }
}
