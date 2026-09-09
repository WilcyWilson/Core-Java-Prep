package javaprepfirstscope;

public class PlatformThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) { // Java 7 readability cosmetic 1_000_000
            new Thread(() ->
                    System.out.println("running thread")
            ).start();
        }
    }
}
