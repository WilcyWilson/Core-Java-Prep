package javaprepfirstscope;

public class GenericArrayWorkaround<T> {
    private final Object[] array;
    private final int size;

    public GenericArrayWorkaround(int size) {
        array = new Object[size]; // Create object array
        this.size = size;
    }

    public void set(int index, T value) {
        if (index >= size) throw new IndexOutOfBoundsException(
                "Index " + index + " out of bounds " + "for " + "length " + size
        );
        array[index] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException(
                "Index " + index + " out of bounds " + "for " + "length " + size
        );
        return (T) array[index]; // Cast individual element while retrieving instead of whole array
    }

    public static void main(String[] args) {
        GenericArrayWorkaround<String> stringGenericArrayWorkaround = new GenericArrayWorkaround<>(15);
        GenericArrayWorkaround<Integer> integerGenericArrayWorkaround = new GenericArrayWorkaround<>(10);
        try {
            stringGenericArrayWorkaround.set(0, "Hello");
            stringGenericArrayWorkaround.set(13, "Spiderman");
            integerGenericArrayWorkaround.set(0, 1);
            integerGenericArrayWorkaround.set(5, 45);
            integerGenericArrayWorkaround.set(66, 23);
            System.out.println(stringGenericArrayWorkaround.get(0));
            System.out.println(integerGenericArrayWorkaround.get(5));
            System.out.println(integerGenericArrayWorkaround.get(6));
            System.out.println(integerGenericArrayWorkaround.get(10));
            System.out.println("Success");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
