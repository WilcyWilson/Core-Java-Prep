package javaprepfirstscope;

public interface SecondInterface {
    int MAX = 20;

    default void show() {
        System.out.println(MAX + " Hello");
        privateMethodToReuseInDefaultMethod();
    }

    default void show2() {
        privateMethodToReuseInDefaultMethod();
    }

    private void privateMethodToReuseInDefaultMethod() {
        System.out.println("Logging");
    }
}
