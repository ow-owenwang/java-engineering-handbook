import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo02 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        //编译错误
        //list.add(123);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            //此处不需要强转
            String str = it.next();
            System.out.println(str);
        }
    }
}
