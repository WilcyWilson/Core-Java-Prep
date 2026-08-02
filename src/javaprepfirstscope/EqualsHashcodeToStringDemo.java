package javaprepfirstscope;

public class EqualsHashcodeToStringDemo {

    // Overriding just to show these method exists implicitly
    // Reference Equality ==
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // Memory Address Fingerprint
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // Readable representation
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        EqualsHashcodeToStringDemo demo1 = new EqualsHashcodeToStringDemo();
        System.out.println(demo1);

        EqualsHashcodeToStringDemo demo2 = new EqualsHashcodeToStringDemo();
        System.out.println(demo2);

        System.out.println(Integer.toHexString(new EqualsHashcodeToStringDemo().hashCode()));

        System.out.println(demo1.equals(demo1)); // true
        // default equals acts just like ==
        System.out.println(demo1.equals(demo2)); // false

        String string1 = new String("Hello");
        String string2 = new String("Hello");
        System.out.println(string1 == string2); // false
        //String overrides .equals method. Two different object in memory representing same value
        //String overrides all 3 methods
        System.out.println(string1.equals(string2)); // true

        // if equals match then the hashCode must match too in String. Both String has same value therefore their address should be the same too
        System.out.println(string1.hashCode());
        System.out.println(string2.hashCode());
        //implicitly calls string1.toString();
        System.out.println(string1);


    }
}

