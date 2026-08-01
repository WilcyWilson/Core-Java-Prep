package javaprepfirstscope;

public record RecordDemo(String color) {
    // This is being called under the hood by the record
/*    public RecordDemo(String color){
        this.color = color;
    } */

    // Must delegate a non-canonical constructor
    public RecordDemo(String color, String type) {
        this(color); // specific rule about records: any constructor that doesn't exactly match the record's declared components must call default record constructor using this()
        // This is because type is not in the record header
        System.out.println("color: " + color);
        System.out.println("type: " + type);
    }

    public static void main(String[] args) {
        RecordDemo recordDemo = new RecordDemo("Red");
        new RecordDemo("Green", "Liquid");
        System.out.println(recordDemo.color());
    }
}



