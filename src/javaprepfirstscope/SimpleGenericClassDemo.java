package javaprepfirstscope;

public class SimpleGenericClassDemo<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        var genericClassDemo = new SimpleGenericClassDemo<Integer>();
        genericClassDemo.set(21);
        System.out.println(genericClassDemo.get());
    }
}
