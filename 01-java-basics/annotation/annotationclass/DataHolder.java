package annotation.annotationclass;

public class DataHolder<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
