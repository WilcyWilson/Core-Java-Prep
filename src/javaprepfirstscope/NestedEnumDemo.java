package javaprepfirstscope;

public class NestedEnumDemo {
    public static void main(String[] args) {
        // No Outer Instance needed. Can be directly called
        NestedEnum.Status status = NestedEnum.Status.INITIALIZING;
        System.out.println(status);

        NestedEnum nestedEnum = new NestedEnum();
        nestedEnum.setStatus(NestedEnum.Status.PENDING);
        System.out.println(nestedEnum.getStatus());
    }
}
