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

        Object obj = "hello";

        // Compiler doesn't connect the instanceof check to the cast
        if (obj instanceof String) {
            // instanceof Checks type at runtime but still have to manually cast obj to String
            String s = (String) obj;
            // Cast can be wrong and can throw ClassCastException at runtime
//            Integer i = (Integer) obj;
            System.out.println(s.toUpperCase());
            System.out.println(len);
        } else if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println(i*2);
        } else if (obj instanceof Double){
            Double d = (Double) obj;
            System.out.println(d + 10);
        }
    }
}
