package javaprepfirstscope;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SafeSingleton {
    // Prevent instruction reordering
    private static volatile SafeSingleton instance;
    private static final Object internalLock = new Object();

    public static SafeSingleton getInstance() {
        if (instance == null) { // null checking
            synchronized (internalLock) {
                if (instance == null) { // second check with locking
                    instance = new SafeSingleton(); // volatile prevents reordering
                }
            }
        }
        return instance;
    }

    static void main() {
        int numberOfPlatformThreads = 100;

        System.out.println("Using Platform Threads");
        try (ExecutorService executorServicePlatform = Executors.newFixedThreadPool(numberOfPlatformThreads)) {
            for (int i = 0; i < numberOfPlatformThreads; i++) {
                executorServicePlatform.submit(() -> System.out.println(getInstance().hashCode()));
            }
        }

        System.out.println("\n\nUsing Virtual Threads");
        try (ExecutorService executorServiceVirtual = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < numberOfPlatformThreads; i++) {
                executorServiceVirtual.submit(() -> System.out.println(getInstance().hashCode()));
            }
        }

    }
}
