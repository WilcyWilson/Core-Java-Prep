package javaprepfirstscope;

public class OldSwitchAndInstanceof {
    public static void main(String[] args) {
        // Old switch only accepts primitives, enums, strings
        String day = "Monday";
        int len = 0;
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

        System.out.println(len);
        System.out.println();

        // no break required
        day = "Tuesday";
        int len2 = switch (day) {
            case "Monday", "Friday", "Sunday" -> 6;
            case "Tuesday" -> 7;
            default -> -1;
        };

        System.out.println(len2);
        System.out.println();

        Object obj = "hello";

        // Compiler doesn't connect the instanceof check to the cast
        if (obj instanceof String) {
            // instanceof Checks type at runtime but still have to manually cast obj to String
            String s = (String) obj;
            // Cast can be wrong and can throw ClassCastException at runtime
//            Integer i = (Integer) obj;
            System.out.println(s.toUpperCase());
            System.out.println();
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
            System.out.println();
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
        System.out.println();
        int n = 5;
        String s = switch (n) {
            case 1, 2 -> "Small";
            case 3, 4 -> "Medium";
            case 5 -> {
                System.out.println("Printing Large");
                yield "Large"; // yield is return for switch
            }
            default -> "Unknown";
        };
        System.out.println(s);
        System.out.println();

        System.out.println(describe(5));
        System.out.println(describe("Spiderman"));
        System.out.println(describe(150));
        System.out.println(describe(-5));
        System.out.println(describe(null));
        System.out.println(describe(new OldSwitchAndInstanceof()));
        System.out.println();

        //Exhaustive Checking
        enum Day {
            MON, TUE, WED, THU, FRI, SAT, SUN
        }

        Day d = Day.SAT;

        String whichDay = switch (d) {
            // In enhanced switch compiler warns if all the possible values are not covered
//            case MON, TUE, WED, THU -> "Workday"; 
            case MON, TUE, WED, THU, FRI -> "Workday";
            case SAT, SUN -> "Weekend";
            // no default needed since all enums are handled
        };

        System.out.println(whichDay);
        System.out.println();

        d = Day.MON;

        // old switch still handles enum
        // default is not compulsory
        // doesn't care about exhaustiveness, works even when FRI is missing
        switch (d) {
            case MON, TUE, WED, THU:
                System.out.println("Workday");
                break;
            case SAT:
                System.out.println("Weekend");
                break;
        }


    }

    // Guard patterns (type + condition without if) Java 21+
    static String describe(Object obj) {
        return switch (obj) {
            case String s when s.length() > 5 -> "Long String: " + s;
            case String s -> "Short String: " + s;
            case Integer i when i > 100 -> "Big number: " + i;
            case Integer i when i < 0 -> "Negative number:" + i;
            case Integer i -> "Small number: " + i;
            case null ->
                    "Null"; // null handling (Traditional switch throws null pointer exception if obj is null. No way to handle null)
            default -> "Unknown";
        };
    }
}
