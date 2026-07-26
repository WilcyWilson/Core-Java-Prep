package currentscope;

public class ConstructorClass {
    private final String b;

    ConstructorClass(String b) {
        System.out.println("Inside ConstructorClass");
        this.b = b + " " + "rtx";
    }

    public void valueOfb() {
        System.out.println("Inside valueOfb");
        System.out.println(b);
    }

    public static void main(String[] args) {
        ConstructorClass c = new ConstructorClass("abc");
        c.valueOfb();
    }
}
