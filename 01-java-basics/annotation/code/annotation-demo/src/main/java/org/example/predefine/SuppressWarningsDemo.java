package org.example.predefine;

/*
 * @SuppressWarnings：压制警告
 * */
@SuppressWarnings("all")
public class SuppressWarningsDemo {
    @Deprecated
    public static void fn() {
    }

    public static void main(String[] args) {
        fn();
    }
}
