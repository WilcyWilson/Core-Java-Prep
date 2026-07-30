package javaprepfirstscope;

// Class inside a method of another enclosing class
public class LocalInnerClassLocalVariableFinalDemo {
    private int a = 20; // Instance Field can be reassigned

    void display() {
        String localVariable = "Local Variable in Method";
        final StringBuilder stringbuilder = new StringBuilder("A"); // Reference is final
        //  localVariable = "Hello here"; // Variable 'localVariable' is accessed from within inner class, needs to be final or effectively final
        class LocalInnerClass {
            void displayInsideClass() {
//              localVariable = "Hello"; // Variable 'localVariable' is accessed from within inner class, needs to be final or effectively final
                System.out.println(localVariable);
                a = 21; // Outer Class Instance Field reassigned
                System.out.println(a);

                stringbuilder.append("B"); // But can be mutated
//              stringbuilder = new StringBuilder("Hello"); // Error Reassigning the Reference
                System.out.println(stringbuilder);
            }

        }
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.displayInsideClass();
    }

    public static void main(String[] args) {
        LocalInnerClassLocalVariableFinalDemo localInnerClassLocalVariableFinalDemo = new LocalInnerClassLocalVariableFinalDemo();
        localInnerClassLocalVariableFinalDemo.display();
    }
}
