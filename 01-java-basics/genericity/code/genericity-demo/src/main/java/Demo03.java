import domain.CustomGenericClass;

public class Demo03 {
    public static void main(String[] args) {
        CustomGenericClass<Integer> cgc = new CustomGenericClass<>();
        cgc.setE(10000);
        System.out.println(cgc.getE());//10000

        CustomGenericClass<String> cgc1 = new CustomGenericClass<>();
        cgc1.setE("ABC");
        System.out.println(cgc1.getE());//ABC
    }
}
