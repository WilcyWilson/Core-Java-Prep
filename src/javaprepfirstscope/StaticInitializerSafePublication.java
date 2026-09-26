package javaprepfirstscope;

public class StaticInitializerSafePublication {
    // JVM guarantees that static initializers are executed in a thread safe manner
    // Any object instantiated in a static field is fully constructed before any thread can access it
    public static final StaticInitializerSafePublication INSTANCE = new StaticInitializerSafePublication();

    private final int port;

    private StaticInitializerSafePublication() {
        this.port = 800;
    }

    // Before running main() the JVM runs all static initializers. It calls new StaticInitializerSafePublication()
    // running the constructor and setting port = 800
    static void main() throws InterruptedException {
        Thread t = new Thread(() -> System.out.println(StaticInitializerSafePublication.INSTANCE.port));
        t.start();
        t.join();
    }
}
