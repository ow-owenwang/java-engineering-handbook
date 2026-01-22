package annotation.annotationmethod;

public class MyUtil {
    public static <E> void print(E e) {
        System.out.println("增强打印：" + e);
    }

    public <T> T get(T t) {
        return t;
    }

    public static void main(String[] args) {
        MyUtil.print("abc");

        MyUtil myUtil = new MyUtil();
        Integer i = myUtil.get(3);
        System.out.println(i);
    }
}
