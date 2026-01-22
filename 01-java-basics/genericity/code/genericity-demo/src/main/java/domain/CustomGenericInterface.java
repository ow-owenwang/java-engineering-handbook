package domain;

public interface CustomGenericInterface<E> {
    public abstract void add(E e);

    public abstract E get();
}
