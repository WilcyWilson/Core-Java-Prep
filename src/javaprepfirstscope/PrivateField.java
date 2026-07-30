package javaprepfirstscope;

public final class PrivateField extends NonAbstractSealedClass {
    final private String a = "abc";

    private void abc() {
//        a = "rtx";
        System.out.println(a);
    }

    public static void main(String[] args) {
        PrivateField f = new PrivateField();
        f.abc();
        f.testMethod();
    }
}

