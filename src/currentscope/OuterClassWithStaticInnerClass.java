package currentscope;

public class OuterClassWithStaticInnerClass {
    public static String a = "abc";

    OuterClassWithStaticInnerClass() {
        System.out.println("\nOuterClassWithStaticInnerClass() Constructor");
    }

    private void getOutside() {
        System.out.println("\nOuterClass getOutside()");
    }

    private static void getStaticOutside() {
        System.out.println("\nOuterClass getStaticOutside()");
    }

    public static class InnerClass {
        public void getInner() {
            System.out.println("\nInside getInner " + a);
        }

        public static void getStaticInner() {
            System.out.println("\nInside getStaticInner");
        }

        InnerClass() {
            System.out.println("\nInside InnerClass() Constructor");
        }

        public static void main(String[] args) {
            String b = a;
            System.out.println("\nInside main innerclass " + b);
        }

        public class InnerInnerClass {
            public static void getStaticInnerInner() {
                System.out.println("\nInside getStaticInnerInner " + a);
            }

            public void getInnerInner() {
                System.out.println("\nInside getInnerInner " + a);
            }

            public static void main(String[] args) {
                System.out.println("\nInside main getInnerInner " + a);
            }

            InnerInnerClass() {
                System.out.println("\nInside InnerInnerClass() Constructor");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("\nInside main Outerclass");

        OuterClassWithStaticInnerClass outerClass = new OuterClassWithStaticInnerClass();

        outerClass.getOutside(); // Calling method normally using object

        System.out.println(outerClass.getClass().descriptorString());

        OuterClassWithStaticInnerClass.getStaticOutside(); // Using class name static

        OuterClassWithStaticInnerClass.InnerClass s = new OuterClassWithStaticInnerClass.InnerClass(); // InnerClass is static
        s.getInner(); // calling method using static inner class. Need to define an object as shown above to call non-static method of a static class.
        OuterClassWithStaticInnerClass.InnerClass.getStaticInner(); // Calling static method of inner class

        OuterClassWithStaticInnerClass.InnerClass.main(args); // calling static main method using static inner class

        OuterClassWithStaticInnerClass.InnerClass s2 = new OuterClassWithStaticInnerClass.InnerClass(); // Create object of inner class
        OuterClassWithStaticInnerClass.InnerClass.InnerInnerClass innerInnerObject = s2.new InnerInnerClass(); // Use that object to define a new InnerInnerClass object since that is not a static class

        InnerClass.InnerInnerClass.getStaticInnerInner(); // Calling static method of InnerInnerClass

        innerInnerObject.getInnerInner(); // Calling normal method of InnerInnerClass

        OuterClassWithStaticInnerClass.InnerClass.InnerInnerClass.main(args); // Calling main of non-static innerinner class
    }
}
