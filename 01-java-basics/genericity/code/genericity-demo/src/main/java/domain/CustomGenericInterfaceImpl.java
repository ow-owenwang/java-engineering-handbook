package domain;

public class CustomGenericInterfaceImpl implements CustomGenericInterface<String> {
    private String str;

    @Override
    public void add(String s) {
        str = s;
    }

    @Override
    public String get() {
        return str;
    }
}
