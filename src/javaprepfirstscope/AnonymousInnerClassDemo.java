package javaprepfirstscope;

public class AnonymousInnerClassDemo {
    private int outerClassNumber = 99;
    private static int outerClassStaticNumber = 123;
    private AnonymousInnerClassInterface anonymousInnerClassInterface;

    public void test() {
        int effectivelyFinal = 2; // Effectively Final just like Local Inner Class

        // Using Anonymous Inner Class to implement an interface on the fly
        AnonymousInnerClassInterface obj = new AnonymousInnerClassInterface() {
            private int value;

            // Instance Initializer
            {
                value = 65;
            }

            @Override
            public void display() {
                System.out.println("AnonymousInnerClassInterface display");
            }

            @Override
            public void display2() {
                System.out.println("AnonymousInnerClassInterface display2");
                System.out.println("effectivelyFinal = " + effectivelyFinal);
                System.out.println(AnonymousInnerClassDemo.outerClassStaticNumber); // Using proper Class type
                System.out.println(AnonymousInnerClassDemo.this.outerClassNumber); // Using proper OuterClass Object Instantiation with this
                // effectivelyFinal = 3; effectively final
                anonymousMethod();
            }

            public void anonymousMethod() {
                System.out.println("AnonymousInnerClassInterface anonymousMethod " + value);
            }
        };
        obj.display();
        obj.display2();
        // New Method defined inside anonymous inner class can't be called
        // obj.anonymousMethod();

        // Using Anonymouse Inner Class to extend a class on the fly
        AnonymousInnerClassExtendedDemo obj2 = new AnonymousInnerClassExtendedDemo() {
            @Override
            public void displayMethod() {
                System.out.println("display Inner Class Demo");
            }
        };
        obj2.displayMethod();
        obj2.displayMethod(55);
    }

    public static void main(String[] args) {
        AnonymousInnerClassDemo obj = new AnonymousInnerClassDemo();
        obj.test();
    }
}

