package javaprepfirstscope;

import java.util.Objects;

// overriding equals but not hash code

public class BrokenContractWithHashCode {
    private final String name;

    BrokenContractWithHashCode(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true; // Checking memory reference
        if (obj == null || obj.getClass() != this.getClass()) return false; // checking if both comes from same class
        return (Objects.equals(name, ((BrokenContractWithHashCode) obj).name)); // Using Objects to compare the value of both the objects
    }

    // Missing hashcode method
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}

