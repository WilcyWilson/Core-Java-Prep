package javaprepfirstscope;

sealed interface Shape permits Circle2, Rectangle, Square2 {
    void printArea();
}

record Circle2(double radius) implements Shape {
    @Override
    public void printArea() {
        System.out.print("Area of circle with radius " + radius + " is ");
    }
}

record Rectangle(double width, double height) implements Shape {
    @Override
    public void printArea() {
        System.out.print("Area of rectangle with width " + width + " and " + " height " + height + " is ");
    }
}

record Square2(double side) implements Shape {
    @Override
    public void printArea() {
        System.out.print("Area of square with side " + side + " is ");
    }
}

// Exhaustiveness verified
public class SealedInterfacePatternMatching {
    double area(Shape shape) {
        shape.printArea();
        // If printArea() was not in Shape interface we can use below to call individual methods of the record
//        switch (shape) {
//            case Circle2 c -> c.printArea();
//            case Square2 s -> s.printArea();
//            case Rectangle r -> r.printArea();
//        }
        return switch (shape) {
            case Circle2(double radius) -> Math.PI * radius * radius;
            case Rectangle(double width, double height) -> width * height;
            case Square2(double side) -> side * side;
            // No default type needed since the compiler knows these are all the permitted types
        };
    }

    public static void main(String[] args) {
        System.out.println(new SealedInterfacePatternMatching().area(new Circle2(5.5)));
        System.out.println(new SealedInterfacePatternMatching().area(new Rectangle(6.6, 2.5)));
        System.out.println(new SealedInterfacePatternMatching().area(new Square2(4.5)));
    }
}