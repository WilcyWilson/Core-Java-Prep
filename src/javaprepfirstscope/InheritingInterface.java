package javaprepfirstscope;

public interface InheritingInterface extends FirstInterface, SecondInterface {

    @Override
    default void show() {
        FirstInterface.super.show();
        SecondInterface.super.show();
    }

    static int add(int a, int b) {
        return a + b;
    }

}

