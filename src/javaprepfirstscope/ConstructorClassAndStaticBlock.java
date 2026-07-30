package javaprepfirstscope;

public class ConstructorClassAndStaticBlock {
    private final String b;

    static {
        System.out.println("Inside Static Block: Runs before main");
    }

    ConstructorClassAndStaticBlock(String b) {
        System.out.println("Inside ConstructorClass");
        this.b = b + " " + "rtx";
    }

    public void valueOfb() {
        System.out.println("Inside valueOfb");
        System.out.println(b);
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        ConstructorClassAndStaticBlock c = new ConstructorClassAndStaticBlock("abc");
        c.valueOfb();
    }
}

