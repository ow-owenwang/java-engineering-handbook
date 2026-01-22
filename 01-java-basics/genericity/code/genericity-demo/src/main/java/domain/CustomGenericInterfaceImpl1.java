package domain;

public class CustomGenericInterfaceImpl1<E> implements CustomGenericInterface<E> {
    private E e;

    @Override
    public void add(E e1) {
        e = e1;
    }

    @Override
    public E get() {
        return e;
    }
}
