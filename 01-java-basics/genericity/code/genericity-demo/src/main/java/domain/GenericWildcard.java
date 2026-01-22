package domain;

import java.util.Collection;

public class GenericWildcard {
    public void method(Collection<?> collection) {
        System.out.println(collection);
    }

    /**
     * 必须是 Number 类型或者 Number 类型的子类
     *
     * @param collection
     */
    public void method01(Collection<? extends Number> collection) {
        System.out.println(collection);
    }

    /**
     * 必须是 Number 类型或者 Number 类型的父类
     *
     * @param collection
     */
    public void method02(Collection<? super Number> collection) {
        System.out.println(collection);
    }
}
