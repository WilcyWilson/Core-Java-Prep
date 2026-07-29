package currentscope;

public class AnonymousInnerClassExtendedDemo {
    private final int number = 21;

    void displayMethod() {
        System.out.println("Class Overridden by Anonymous Class" + number);
    }

    void displayMethod(int number) {
        System.out.println("Overloaded: " + number);
    }
}
