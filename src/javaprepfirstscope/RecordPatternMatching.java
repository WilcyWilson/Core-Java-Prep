package javaprepfirstscope;

record Point(int x, int y) {
}

record Circle(Point center, double radius) {
}

record Square(Point area) {
}

// Record patterns extracts components directly into variables. No manual .x() needs to be called
class RecordPatternMatching {
    String describe(Object shape) {
        return switch (shape) {
            case Point(int x, int y) when x == 0 && y == 0 -> "Origin";

            case Point(int x, int y) -> "Point at (" + x + ", " + y + ")";

            case Circle(Point c, double r) -> "Circle at (" + c.x() + ", " + c.y() + ") with radius " + r;


            default -> "Unknown Shape";
        };
    }

    public static void main(String[] args) {
        System.out.println(new RecordPatternMatching().describe(new Point(6, 5)));
        System.out.println(new RecordPatternMatching().describe(new Circle(new Point(5, 2), 2.5)));
        System.out.println(new RecordPatternMatching().describe(new Square(new Point(4, 2))));
        System.out.println(new RecordPatternMatching().describe(new Point(0, 0)));

        System.out.println();
        Object object = new Point(3, 4);
        if (object instanceof Point(int x, int y)) {
            System.out.println("x=" + x + "," + " y=" + y);
        }
    }
}
