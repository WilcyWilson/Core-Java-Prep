package javaprepfirstscope;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.LongStream;

public class PlatformThreads {
    public static void main(String[] args) throws InterruptedException {
//        try {
//        virtualThreadDemo();
//         platformThreadOutOfMemoryDemo();
//        platformThreadMaxCPUUtilization();
//        virtualThreadCreationOption1();
//        virtualThreadCreationOption2();
//        virtualThreadCreationOption3();
        Thread.sleep(3000);

        cpuPinningVirtualThread();
        usingReentrantLockVirtualThread();

        // always JVM Warmup and JIT Compilation Tax
        // JVM interprets the bytecode line by line on first LongStream
        // Micro benchmarking like this is frowned upon, but I'm just using it to test
//            virtualThreadCPUBoundTest();
//            platformThreadWithParallelProcessingForCPUIntensiveWork();
//            directParallelProcessingForCPUIntensiveWork();
//            platformThreadTest();
//            Thread.sleep(200);
//            System.out.println();
//            virtualThreadCPUBoundTest();
//            platformThreadWithParallelProcessingForCPUIntensiveWork();
//            directParallelProcessingForCPUIntensiveWork();
//            platformThreadTest();
//        }
//        catch (InterruptedException e) {
//            throw new RuntimeException();
//        }
    }

    public static void platformThreadOutOfMemoryDemo() {
        for (int i = 0; i < 1_000_000; i++) { // Java 7 readability cosmetic 1_000_000
            Thread t = new Thread(() -> {
                System.out.println("Running Thread" + Thread.currentThread());
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            );
            t.start();

            // Make the current thread pause and wait right here until thread t finishes its work.
            // Calling t.join() in the for loop means we are telling the main thread to stop and wait for
            // the newly spawned thread to finish its printing task before the loop can continue to the next iteration
//            t.join();
        }
    }

    public static void platformThreadMaxCPUUtilization() {
        int cores = Runtime
                .getRuntime()
                .availableProcessors();
        for (int i = 0; i < cores; i++) { // Java 7 readability cosmetic 1_000_000
            Thread t = new Thread(() -> {
                double dummyVariable;
                while (true) {
                    // System.out.println is synchronized, slow I/O operation.
                    // printing to console yield the CPU to go to sleep
                    // Math.pow runs almost instantly
                    // CPU spends significant portion of time managing the traffic jam instead of
                    // executing the math instruction
//                    System.out.println("Running Thread" + Thread.currentThread());
                    dummyVariable = Math.pow(
                            ThreadLocalRandom
                                    .current()
                                    .nextInt(5, 100),
                            ThreadLocalRandom
                                    .current()
                                    .nextInt(5, 100));
//                    System.out.println(dummyVariable);
                }
            }
            );
            t.start();

            // Make the current thread pause and wait right here until thread t finishes its work.
            // Calling t.join() in the for loop means we are telling the main thread to stop and wait for
            // the newly spawned thread to finish its printing task before the loop can continue to the next iteration
//            t.join();
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
    public static void virtualThreadCreationOption1() throws InterruptedException {
        Thread v = Thread.startVirtualThread(() -> System.out.println("Running on virtual thread: " + Thread.currentThread()));
        v.join(); // main waits until v finishes
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


    // CPU Pinning where virtual thread cannot unmount from its carrier thread
    // This is bad
    // -XX:StartFlightRecording=jdk.VirtualThreadPinned#threshold=0ms,filename=recording.jfr in VM in config to check CPU Pinning in JFR
    public static void cpuPinningVirtualThread() {
        try {
            Thread.startVirtualThread(() -> {
                synchronized (PlatformThreads.class) { // Virtual thread is pinned
                    System.out.println("Synchronized Virtual Thread"); // Blocks carrier thread too
                    try {
                        // This blocking call inside synchronized is what forces JDK 21 to pin carrier thread
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } // no other virtual thread can use the carrier thread now until this
            }).join();

            // Giving JFR extra moment to capture and write the data
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // ReentrantLock is Virtual Thread friendly and works with Platform Threads too
    // JVM knows how to unmount ReentrantLock
    public static void usingReentrantLockVirtualThread() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread.startVirtualThread(() -> {
            reentrantLock.lock();       // Virtual Thread can unmount here
            try {
                System.out.println("Blocked Carrier Thread is free"); // Blocks but the carrier thread is free
            } finally {
                reentrantLock.unlock();
            }
        }).join();
    }


}
