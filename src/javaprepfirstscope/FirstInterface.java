package javaprepfirstscope;

public interface FirstInterface {
    void display(String input);

    int number();

    default void show() {
        System.out.println("Diamond Problem");
    }
}

