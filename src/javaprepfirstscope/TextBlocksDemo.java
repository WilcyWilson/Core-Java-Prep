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
                "name": "Bruce",  \s
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

        // \s preserves trailing spaces which are normally stripped
        // drag the mouse pointer to see the space in the output
        String spaces = """
                line1 \s
                line2 \s
                """;
        System.out.println(spaces);

        String longline = """
                This is a very long line \
                and all this line should appear in the same line without \
                new line breaking these line.
                """;
        System.out.println(longline);
    }
}
