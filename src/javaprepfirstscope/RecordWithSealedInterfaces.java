package javaprepfirstscope;

sealed interface Expr permits Constant, Add, Multiply {
}

record Constant(int value) implements Expr {
}

record Add(Expr left, Expr right) implements Expr {
}

record Multiply(Expr left, Expr right) implements Expr {
}

class RecordWithSealedInterfaces {
    public static void main(String[] args) {
        Constant c1 = new Constant(32);
        Constant c2 = new Constant(23);
        Constant c3 = new Constant(21);

        Expr add = new Add(c1, c2);
        Expr multiply = new Multiply(add, c3);

        System.out.println(eval(c1));
        System.out.println(toExpressionString(add) + " = " + eval(add));

        System.out.println(toExpressionString(multiply) + " = " + eval(multiply));

        Expr multiply2 = new Multiply(c1, c2);
        System.out.println(toExpressionString(multiply2) + " = " + eval(multiply2));

        Expr multiply3 = new Multiply(c3, add);
        System.out.println(toExpressionString(multiply3) + " = " + eval(multiply3));

        Expr multiply4 = new Multiply(multiply2, multiply3);
        System.out.println(toExpressionString(multiply4) + " = " + eval(multiply4));
    }

    // Sealed interface enables Exhaustive switch
    static int eval(Expr expr) {
        return switch (expr) {
            case Constant(int v) -> v;
            case Add(Expr l, Expr r) -> eval(l) + eval(r); // Recursion
            case Multiply(Expr l, Expr r) -> eval(l) * eval(r); // Recursion
            // No default needed. Compiler knows all cases
        };
    }

    static String toExpressionString(Expr expr) {
        return switch (expr) {
            case Constant(int v) -> String.valueOf(v);
            case Add(Expr l, Expr r) -> """
                    (%s + %s)\
                    """.formatted(toExpressionString(l), toExpressionString(r));
            case Multiply(Expr l, Expr r) -> """
                    (%s * %s)\
                    """.formatted(toExpressionString(l), toExpressionString(r)); //  Recursion
        };
    }
}
