package javaprepfirstscope;

public class EnumClassDemo {
    public static void main(String[] args) {
        System.out.println(EnumDemo.ACTIVE);
        EnumDemo demo = EnumDemo.ACTIVE;
        System.out.println(demo.ordinal());
        System.out.println(EnumDemo.INACTIVE.ordinal());
    }
}
