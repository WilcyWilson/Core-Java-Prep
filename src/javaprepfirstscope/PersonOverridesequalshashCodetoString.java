package javaprepfirstscope;

import java.util.Objects;

public class PersonOverridesequalshashCodetoString {
    private final String name;
    private final int age;

    public PersonOverridesequalshashCodetoString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonOverridesequalshashCodetoString() {
        this("Spider", 28);
        System.out.println("Hello World");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Safe to cast after above verification with getClass
        PersonOverridesequalshashCodetoString other = (PersonOverridesequalshashCodetoString) obj;
        return age == other.age && Objects.equals(name, other.name); // null safe comparison
    }

    // Must match equals logic
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "[Name: " + name + ", Age: " + age + "]";
    }

    public static void main(String[] args) {
        System.out.println(new PersonOverridesequalshashCodetoString());
        PersonOverridesequalshashCodetoString p = new PersonOverridesequalshashCodetoString("John", 25);
        System.out.println(p);
    }
}
