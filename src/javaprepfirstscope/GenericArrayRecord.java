package javaprepfirstscope;

public record GenericArrayRecord<T>(String name, T... address) {

    // T... (varargs) is syntactic sugar for passing a variable number of arguments as an array (T[]
    @SafeVarargs
    public GenericArrayRecord {
        System.out.println(name);
        System.out.println(address.length);
    }

    public static void main(String[] args) {
        String name = "Spider";
        String[] strings = new String[]{"a","aba","spid"};
        GenericArrayRecord<String> genericArrayRecord = new GenericArrayRecord<>(name, strings);
    }
}
