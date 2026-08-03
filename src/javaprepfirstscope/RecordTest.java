package javaprepfirstscope;

import java.util.HashSet;

public class RecordTest{
    public record RecordDemo(Integer id, Boolean isStudent) {
    }

    public static void main(String[] args) {
        RecordDemo recordDemo = new RecordDemo(1,true);
        RecordDemo recordDemo2 = new RecordDemo(1,true);
        HashSet<RecordDemo> hashSet = new HashSet<>();
        hashSet.add(recordDemo);

        // You can see record already overrides the hashCode, equals and toString method
        // so that it compares the value according to their logical value, rather than memory address
        System.out.println(recordDemo.equals(recordDemo2));

        System.out.println(hashSet.contains(recordDemo2));
        System.out.println(recordDemo.hashCode());
        System.out.println(recordDemo2.hashCode());
        System.out.println(recordDemo);
    }
}
