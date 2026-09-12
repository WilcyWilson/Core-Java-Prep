package javaprepfirstscope;

import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class PlatformThreads {
    public static void main(String[] args) throws InterruptedException {
//        virtualThreadDemo();
//         platformThreadDemo();
//        virtualThreadCreationOption1();
//        virtualThreadCreationOption2();
//        virtualThreadCreationOption3();

        // always JVM Warmup and JIT Compilation Tax
        // JVM interprets the bytecode line by line on first LongStream
        // Micro benchmarking like this is frowned upon, but I'm just using it to test
        virtualThreadCPUBoundTest();
        platformThreadWithParallelProcessingForCPUIntensiveWork();
        directParallelProcessingForCPUIntensiveWork();
        platformThreadTest();
        Thread.sleep(200);
        System.out.println();
        virtualThreadCPUBoundTest();
        platformThreadWithParallelProcessingForCPUIntensiveWork();
        directParallelProcessingForCPUIntensiveWork();
        platformThreadTest();
    }

    public static void platformThreadDemo() {
        for (int i = 0; i < 1_000_000; i++) { // Java 7 readability cosmetic 1_000_000
            Thread t = new Thread(() ->
                    System.out.println("running thread")
            );
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void virtualThreadDemo() {
        try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000_000; i++) {
                // Each task gets its own virtual thread
                executor.submit(() -> System.out.println("running thread" + " " + Thread.currentThread()));
            }
        }
    }

    // Creating Virtual Threads
    // startVirtualThread is convenience method which immediately starts the thread
    // Option 1
    public static void virtualThreadCreationOption1() {
        Thread v = Thread.startVirtualThread(() -> System.out.println("Running on virtual thread: " + Thread.currentThread()));
        try {
            v.join(); // main waits until v finishes
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Thread.ofVirtual()
    // Option 2
    public static void virtualThreadCreationOption2() {
        try {
            Thread vthread = Thread
                    .ofVirtual()
                    .name("worker-", 0)
                    .unstarted(() ->
                            System.out.println("Hello from " + Thread
                                    .currentThread()
                                    .getName() + " " + Thread.currentThread()));
            vthread.start();
            vthread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Option 3
    public static void virtualThreadCreationOption3() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() ->
                    System.out.println("Running on virtual thread " + Thread.currentThread()
                    ));
        }
    }

    // Virtual Threads Not faster for CPU-bound work
    // Might be even slower due to mounting/unmounting overhead
    // Parallel streams or platform threads prefered for CPU work
    public static void virtualThreadCPUBoundTest() {
        try {
            long start = System.nanoTime();
            Thread t = Thread
                    .ofVirtual()
                    .unstarted(() -> {
                        // CPU Intensive calculation
                        System.out.println(LongStream
                                .range(0, 1_000_000_000L)
                                .sum());
                    });
            t.start();
            t.join();
            double elapsedMs = (System.nanoTime() - start) / 1_000_000.0;
            System.out.println("Virtual Threads: " + elapsedMs + " ms");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // CPU intensive work using direct parallel processing
    public static void directParallelProcessingForCPUIntensiveWork() {
        long start = System.nanoTime();
        long sum = LongStream
                .range(0, 1_000_000_000L)
                .parallel()
                .sum();
        System.out.println(sum);
        double elapsedMs = (System.nanoTime() - start) / 1_000_000.0;
        System.out.println("Direct Parallel: " + elapsedMs + " ms");
    }

    // CPU intensive work using parallel with platform thread
    public static void platformThreadWithParallelProcessingForCPUIntensiveWork() {
        try {
            long start = System.nanoTime();
            Thread t = new Thread(() -> System.out.println(LongStream
                    .range(0, 1_000_000_000L)
                    .parallel()
                    .sum()));
            t.start();
            t.join();
            double elapsedMs = (System.nanoTime() - start) / 1_000_000.0;
            System.out.println("Platform Threads Plus Parallel: " + elapsedMs + " ms");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // CPU intensive work using platform threads
    public static void platformThreadTest() {
        try {
            long start = System.nanoTime();
            Thread t = new Thread(() -> System.out.println(LongStream
                    .range(0, 1_000_000_000L)
                    .sum()));
            t.start();
            t.join();
            double elapsedMs = (System.nanoTime() - start) / 1_000_000.0;
            System.out.println("Platform Threads: " + elapsedMs + " ms");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
