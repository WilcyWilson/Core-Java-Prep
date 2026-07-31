package javaprepfirstscope;

public class NestedInterfaceDemo {
    public static void main(String[] args) {
        // No Outer Instance needed. Can be directly called since the interface is public static here
        NestedInterface.ImplicitlyStaticInterface implicitlyStaticInterface = () -> System.out.println("Lambda Expression direct static");
        implicitlyStaticInterface.display();

        NestedInterface.Implementer implementer = new NestedInterface().new Implementer();
        implementer.display();
    }
}
