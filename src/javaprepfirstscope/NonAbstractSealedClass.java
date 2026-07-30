package javaprepfirstscope;

public sealed class NonAbstractSealedClass permits PrivateField {
    private final String testString = "Inside NonAbstractSealedClass";

    public void testMethod() {
        System.out.println(testString);
    }

    public void testMethod2() {
        System.out.println(testString);
    }

    public static void main(String[] args) {
        NonAbstractSealedClass sealedClass = new NonAbstractSealedClass();
        sealedClass.testMethod();
        sealedClass.testMethod2();
    }
}
