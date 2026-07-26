package currentscope;

public abstract sealed class SealedClass permits BooleanBasic, StringNew {
    private final String abc = "abc";

    public abstract void aVoid();

    public void nonAbstract() {
        System.out.println("This is a non abstract method");
        System.out.println(abc);
    }
}
