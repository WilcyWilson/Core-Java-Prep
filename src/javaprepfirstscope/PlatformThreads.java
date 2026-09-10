package javaprepfirstscope;

public class PlatformThreads {
    public static void main(String[] args) {
        virtualThreadDemo();
        // platformThreadDemo();
    }

    public static void platformThreadDemo() {
        for (int i = 0; i < 1_000_000; i++) { // Java 7 readability cosmetic 1_000_000
            new Thread(() ->
                    System.out.println("running thread")
            ).start();
        }
    }

    public static void virtualThreadDemo() {
        try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000_000; i++) {
                executor.submit(() -> System.out.println("running thread"));
            }
        }
    }
}
