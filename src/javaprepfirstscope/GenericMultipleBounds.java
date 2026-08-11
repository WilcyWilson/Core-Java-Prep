package javaprepfirstscope;

import java.io.Serializable;

// Multiple bounds with Class and Interfaces
public class GenericMultipleBounds<T extends Animal & Serializable & Cloneable & Comparable> {
    private final T value;

    public GenericMultipleBounds(T value) {
        this.value = value;
    }

    public void displayValue(T compare) {
        System.out.println(this.value.compareTo(compare));
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        var multipleBounds = new GenericMultipleBounds<Animal>(animal);
        multipleBounds.displayValue(animal); // 0 for equal object

        // var multipleBoundsCat = new GenericMultipleBounds<Cat>(new Cat());
        // Cat extends Animal and would interhit all implementation of Animal so GenericMultipleBounds<Cat> would be valid
        multipleBounds.displayValue(new Cat()); // -1 for unequal object
    }
}
