package javaprepfirstscope;// Java program to demonstrate accessing
// a inner class

// outer class
class OuterClassGeeksForGeeks {
    // static member
    static int outer_x = 10;

    // instance(non-static) member
    int outer_y = 20;

    // private member
    private int outer_private = 30;

    // Outer method
    void displayMethod() {
        InnerClass innerObject = new InnerClass();
        // can access static member of outer class
        System.out.println("outer_x = " + innerObject.inner_x);

        // can also access non-static member of outer
        // class
        System.out.println("outer_y = " + InnerClass.inner_y);

        // can also access a private member of the outer
        // class
        System.out.println("outer_private = "
                + innerObject.inner_private);
    }

    // inner class
    class InnerClass {
        int inner_x = 40;
        static int inner_y = 50;
        private int inner_private = 60;

        void display() {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can also access non-static member of outer
            // class
            System.out.println("outer_y = " + outer_y);

            // can also access a private member of the outer
            // class
            System.out.println("outer_private = "
                    + outer_private);
        }
    }
}

