package javaprepfirstscope;

import java.io.Serializable;

public class Animal implements Serializable, Cloneable, Comparable {

    // Implementing our own compareTo logic
    @Override
    public int compareTo(Object o) {
        return this == o ? 0 : -1;
    }
}
