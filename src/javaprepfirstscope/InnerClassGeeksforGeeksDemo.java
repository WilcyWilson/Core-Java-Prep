package javaprepfirstscope;

// Driver class
public class InnerClassGeeksforGeeksDemo {
    public static void main(String[] args) {
        // accessing an inner class
        OuterClassGeeksForGeeks outerObject = new OuterClassGeeksForGeeks();

        outerObject.displayMethod();

        OuterClassGeeksForGeeks.InnerClass innerObject
                = outerObject.new InnerClass();

        innerObject.display();
    }
}
