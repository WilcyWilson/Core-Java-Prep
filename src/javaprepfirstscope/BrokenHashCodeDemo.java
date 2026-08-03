package javaprepfirstscope;

import java.util.HashSet;
import java.util.Set;

public class BrokenHashCodeDemo {
    public static void main(String[] args) {
        BrokenContractWithHashCode b = new BrokenContractWithHashCode("Spiderman");
        BrokenContractWithHashCode b2 = new BrokenContractWithHashCode("Spiderman");
        System.out.println(b);
        System.out.println(b2);
        Set<BrokenContractWithHashCode> set = new HashSet<>();
        set.add(b);

        System.out.println(set.contains(b)); //true
        // contains checks if the memory reference matches between the two objects and since we didn't override the hashCode metrhod here
        // so that the two objects which has same logical values also has same hashCode, this is yielding false
        System.out.println(set.contains(b2)); //false

        // p1 and p2 are equal by equals() so the contract says they should share hash codes but this is broken here.
        System.out.println(b.equals(b2)); //true
    }
}
