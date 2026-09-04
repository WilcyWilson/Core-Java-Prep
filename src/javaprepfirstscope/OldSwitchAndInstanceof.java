package javaprepfirstscope;

public class OldSwitchAndInstanceof {
    public static void main(String[] args) {
        // Old switch only accepts primitives, enums, strings
        String day = "Monday";
        int len;
        switch (day) {
            case "Monday": // missing break fall through case below
            case "Friday":
            case "Sunday":
                len = 6;
                break; // manual break here after fall through
            case "Tuesday":
                len = 7;
                break;
            default:
                len = -1;
        }

        // no break required
        day = "Tuesday";
        int len2 = switch (day) {
            case "Monday", "Friday", "Sunday" -> 6;
            case "Tuesday" -> 7;
            default -> -1;
        };

        Object obj = "hello";

        // Compiler doesn't connect the instanceof check to the cast
        if (obj instanceof String) {
            // instanceof Checks type at runtime but still have to manually cast obj to String
            String s = (String) obj;
            // Cast can be wrong and can throw ClassCastException at runtime
//            Integer i = (Integer) obj;
            System.out.println(s.toUpperCase());
            System.out.println(len);
            System.out.println(len2);
        } else if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println(i * 2);
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            System.out.println(d + 10);
        }

        Object obj2 = "Modern";
        // Modern Way Pattern Matching
        // if
        // type check, cast, and binding in One step
        if (obj2 instanceof String s) { // "s" is automatically the cast to String
            System.out.println(s.toUpperCase()); // no manual cast needed
        } else if (obj2 instanceof Integer i) {
            System.out.println(i * 2);
        } else if (obj2 instanceof Double d) {
            System.out.println(d + 10);
        }

        obj2 = 5.00;
        String result = switch (obj2) {
            // type check, cast, and binding in One step
            // whole switch evaluates to a value
            case String s -> s.toUpperCase();
            case Integer i -> String.valueOf(i * 2);
            case Double d -> "Decimal: " + d;
            default -> "Unknown";
        };

        System.out.println(result);
    }
}
