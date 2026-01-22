import domain.CustomGenericInterfaceImpl;
import domain.CustomGenericInterfaceImpl1;
import domain.CustomGenericMethod;

public class Demo04 {
    public static void main(String[] args) {
        CustomGenericMethod cgm = new CustomGenericMethod();
        cgm.method01("A");
        cgm.method01(10000);
        Integer integer = cgm.method02(10000);
        System.out.println(integer);

        CustomGenericMethod.method03(10000);

        CustomGenericInterfaceImpl cgi = new CustomGenericInterfaceImpl();
        CustomGenericInterfaceImpl1<String> cgi1 = new CustomGenericInterfaceImpl1<>();

    }
}
