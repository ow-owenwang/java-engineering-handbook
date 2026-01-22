package domain;

/**
 * 含有泛型的方法
 */
public class CustomGenericMethod {
    public <E> void method01(E e) {
        System.out.println(e);
    }

    public <E> E method02(E e) {
        return e;
    }

    /**
     * 含有泛型的静态方法
     *
     * @param e
     * @param <E>
     * @return
     */
    public static <E> E method03(E e) {
        return e;
    }
}
