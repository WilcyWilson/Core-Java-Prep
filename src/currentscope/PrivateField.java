package currentscope;

public class PrivateField {
    final private String a = "abc";

    private void abc() {
//        a = "rtx";
        System.out.println(a);
    }

    public static void main(String[] args) {
        PrivateField f = new PrivateField();
        f.abc();
    }
}

