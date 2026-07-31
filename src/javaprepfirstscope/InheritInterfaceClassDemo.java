package javaprepfirstscope;

public class InheritInterfaceClassDemo implements InheritingInterface {

    @Override
    public void show() {
        System.out.println("Hello World");
    }

    @Override
    public void display(String input) {
        System.out.println(input);
    }

    @Override
    public int number() {
        return 5;
    }

    public static void main(String[] args) {
        InheritInterfaceClassDemo inheritInterfaceClassDemo = new InheritInterfaceClassDemo();
        inheritInterfaceClassDemo.display("What's up!!!");
        inheritInterfaceClassDemo.show();
        inheritInterfaceClassDemo.show2();
        // FirstInterface firstInterface = input -> System.out.println("ABC"); // Not a functional interface
        System.out.println(inheritInterfaceClassDemo.number());
        System.out.println(InheritingInterface.add(inheritInterfaceClassDemo.number(), inheritInterfaceClassDemo.number()));
    }
}
