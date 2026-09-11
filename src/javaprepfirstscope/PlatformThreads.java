package javaprepfirstscope;

public class PlatformThreads {
    public static void main(String[] args) {
//        virtualThreadDemo();
//         platformThreadDemo();
        virtualThreadCreationOption1();
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

    // Creating Virtual Threads
    // Option 1
    public static void virtualThreadCreationOption1() {
        Thread v = Thread.startVirtualThread(() -> System.out.println("Running on virtual thread: " + Thread.currentThread()));
        try {
            v.join(); // main waits until v finishes
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
