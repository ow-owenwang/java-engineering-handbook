import domain.GenericWildcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo06 {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        GenericWildcard gw = new GenericWildcard();
        gw.method01(list1);
        //gw.method01(list2);//报错
        gw.method01(list3);
        //gw.method01(list4);//报错

        //gw.method02(list1);//报错
        //gw.method02(list2);//报错
        gw.method02(list3);
        gw.method02(list4);
    }
}
