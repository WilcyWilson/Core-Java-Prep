package javaprepfirstscope;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // List thinks everything is an Object type
        List list = new ArrayList();
        list.add("A");
        list.add(21);
        list.add(new Date().getTime());

        // String retriveFirst = list.getFirst(); // Compiler only knows it's an Object
        String retriveFirst = (String) list.getFirst(); // So, cast is required
        // String  retriveSecond =  (String) list.get(1); // ClassCastException. We are trying to cast Integer to String
        System.out.println(retriveFirst);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
