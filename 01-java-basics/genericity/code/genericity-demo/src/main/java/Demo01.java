import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo01 {
    public static void main(String[] args) {
        //没有泛型的集合可以存储任意类型的数据
        Collection collection = new ArrayList();
        collection.add("A");
        collection.add("B");
        collection.add(123);

        Iterator it = collection.iterator();
        while (it.hasNext()) {
            //强转时出现异常
            String str = (String) it.next();
            System.out.println(str);
        }
    }
}
