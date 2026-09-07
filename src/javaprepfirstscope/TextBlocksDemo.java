package javaprepfirstscope;

public class TextBlocksDemo {
    public static void main(String[] args) {
        // Old way
        String json = "{\n" + " \"name\": \"Bruce\" \n}";

        System.out.println(json);
        System.out.println();

        // With Text Blocks. Clean, Readable, Preserves text formating
        String json2 = """
                {
                "name": "Bruce",
                "age": 40,
                "city": "Gotham"
                }
                """;
        System.out.println(json2);

        String indented = """
                line1
                line2
            """; //Moving the closing delimiter preserves the leading white spaces
        // Result: "    line 1\n    line 2"  (4 spaces preserved)
        System.out.println(indented);
    }
}
