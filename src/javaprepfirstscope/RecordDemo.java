package javaprepfirstscope;

public record RecordDemo(String color) {
    public static void main(String[] args) {
        RecordDemo recordDemo = new RecordDemo("Red");
        System.out.println(recordDemo.color());
    }
}



