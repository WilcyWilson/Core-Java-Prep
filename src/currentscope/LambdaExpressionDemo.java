package currentscope;

public class LambdaExpressionDemo {
    private String outerInstanceVariable = "OuterInstance";

    private static void output() {
        // String test = "Testing"; // Effectively final
        // Anonymous Inner Class Calling FunctionalInterface
        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo() {
            @Override
            public void display(String input) {
                // test = "Not Testing"; // Effectively Final so this is wrong
                LambdaExpressionDemo lambdaExpressionDemo = new LambdaExpressionDemo();
                lambdaExpressionDemo.outerInstanceVariable = "Hello"; // Instance Variable of outerClass Can be mutated
                System.out.println(lambdaExpressionDemo.outerInstanceVariable + input);
            }
        };
        functionalInterfaceDemo.display(" World");

        // Lambda Expression
        FunctionalInterfaceDemo functionalInterfaceDemoWithLambdaExpression = input -> System.out.println("Lambda says " + input);
        FunctionalInterfaceDemo functionalInterfaceDemoWithLambdaExpression2 = input -> {
            LambdaExpressionDemo lambdaExpressionDemo = new LambdaExpressionDemo();
            System.out.println(lambdaExpressionDemo.outerInstanceVariable + input);
        }; // Display method body in FunctionalInterfaceDemo
        functionalInterfaceDemoWithLambdaExpression.display("Hello");
        functionalInterfaceDemoWithLambdaExpression2.display(" Outer Class inside lambda expression");
    }

    public static void main(String[] args) {
        LambdaExpressionDemo.output();
    }
}

