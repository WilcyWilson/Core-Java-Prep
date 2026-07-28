package currentscope;

public class OuterClassBreakingWithInfiniteLoop {
    private static String a = "abc";
    InnerClassBreakingWithInifiniteLoop innerClassBreakingWithInifiniteLoop = new InnerClassBreakingWithInifiniteLoop();

    OuterClassBreakingWithInfiniteLoop() {
        System.out.println("\nOuterClassWithStaticInnerClass() Constructor");
        innerClassBreakingWithInifiniteLoop.getInner();
        System.out.println(innerClassBreakingWithInifiniteLoop.innerClassInteger);
        InnerClassBreakingWithInifiniteLoop.getStaticInner();
    }

    private void getOutside() {
        System.out.println("\nOuterClass getOutside()");
    }

    private static void getStaticOutside() {
        InnerClassBreakingWithInifiniteLoop innerClassBreakingWithInifiniteLoop = new InnerClassBreakingWithInifiniteLoop();
        System.out.println(innerClassBreakingWithInifiniteLoop.innerClassInteger);
        System.out.println("\nOuterClass getStaticOutside()");
    }

    private static class InnerClassBreakingWithInifiniteLoop {
        private final int innerClassInteger = 10;

        private void getInner() {
            System.out.println("\nInside getInner " + a);
            InnerInnerClassBreakingWithInfiniteLoop innerInnerClassBreakingWithInfiniteLoop = new InnerInnerClassBreakingWithInfiniteLoop();
            innerInnerClassBreakingWithInfiniteLoop.getInnerInner();
        }

        private static void getStaticInner() {
            System.out.println("\nInside getStaticInner");
        }

        InnerClassBreakingWithInifiniteLoop() {
            System.out.println("\nInside InnerClass() Constructor");
        }

        private static void main(String[] args) {
            String b = a;
            System.out.println("\nInside main innerclass " + b);
        }

        private class InnerInnerClassBreakingWithInfiniteLoop {
            private static void getStaticInnerInner() {
                System.out.println("\nInside getStaticInnerInner " + a);
            }

            private void getInnerInner() {
                System.out.println("\nInside getInnerInner " + a);
                OuterClassBreakingWithInfiniteLoop outerClass = new OuterClassBreakingWithInfiniteLoop();
                outerClass.getOutside();
                OuterClassBreakingWithInfiniteLoop.getStaticOutside();
            }

            private static void main(String[] args) {
                System.out.println("\nInside main getInnerInner " + a);
            }

            InnerInnerClassBreakingWithInfiniteLoop() {
                System.out.println("\nInside InnerInnerClass() Constructor");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("\nInside main Outerclass");

        OuterClassBreakingWithInfiniteLoop outerClass = new OuterClassBreakingWithInfiniteLoop();

        outerClass.getOutside(); // Calling method normally using object

        System.out.println(outerClass.getClass().descriptorString());

        OuterClassBreakingWithInfiniteLoop.getStaticOutside(); // Using class name static

        InnerClassBreakingWithInifiniteLoop s = new InnerClassBreakingWithInifiniteLoop(); // InnerClass is static
        System.out.println(s.innerClassInteger);
        s.getInner(); // calling method using static inner class. Need to define an object as shown above to call non-static method of a static class.
        InnerClassBreakingWithInifiniteLoop.getStaticInner(); // Calling static method of inner class

        InnerClassBreakingWithInifiniteLoop.main(args); // calling static main method using static inner class

        InnerClassBreakingWithInifiniteLoop s2 = new InnerClassBreakingWithInifiniteLoop(); // Create object of inner class
        InnerClassBreakingWithInifiniteLoop.InnerInnerClassBreakingWithInfiniteLoop innerInnerObject = s2.new InnerInnerClassBreakingWithInfiniteLoop(); // Use that object to define a new InnerInnerClass object since that is not a static class

        InnerClassBreakingWithInifiniteLoop.InnerInnerClassBreakingWithInfiniteLoop.getStaticInnerInner(); // Calling static method of InnerInnerClass

        innerInnerObject.getInnerInner(); // Calling normal method of InnerInnerClass

        InnerClassBreakingWithInifiniteLoop.InnerInnerClassBreakingWithInfiniteLoop.main(args); // Calling main of non-static innerinner class
    }
}

