package javaprepfirstscope;

public class SimpleThread {
    public Runnable simpleThreadDemo() {
        return () -> {
            int i = 0;
            while (i < 20) {
                i++;
                System.out.println("i = " + i + " " + Thread.currentThread().getName());
            }
        };
    }

    // Un-synchronized Thread. No guarantee order of execution of the threads
    // Platform Threads are non-daemon threads like main thread that outlives the main thread
    // JVM waits for all non-daemon thread to complete before shutting down.
    public static void main(String[] args) throws InterruptedException {
        SimpleThread simpleThread = new SimpleThread();
        Thread t1 = new Thread(simpleThread.simpleThreadDemo(), "ThreadOne");
        Thread t2 = new Thread(simpleThread.simpleThreadDemo(), "ThreadTwo");
        t1.start();
        t2.start();
        // main thread will wait until both child threads t1 and t2 is completed if we use join and the
        // below will be printed at last.
//        t1.join();
//        t2.join();
        System.out.println(Thread.currentThread().getName() + " is complete.");
    }
}

// Output without join()
//  main is complete.
//i = 1 ThreadTwo
//i = 2 ThreadTwo
//i = 3 ThreadTwo
//i = 4 ThreadTwo
//i = 5 ThreadTwo
//i = 6 ThreadTwo
//i = 7 ThreadTwo
//i = 1 ThreadOne
//i = 8 ThreadTwo
//i = 2 ThreadOne
//i = 9 ThreadTwo
//i = 3 ThreadOne
//i = 10 ThreadTwo
//i = 11 ThreadTwo
//i = 12 ThreadTwo
//i = 13 ThreadTwo
//i = 14 ThreadTwo
//i = 15 ThreadTwo
//i = 4 ThreadOne
//i = 5 ThreadOne
//i = 6 ThreadOne
//i = 7 ThreadOne
//i = 8 ThreadOne
//i = 16 ThreadTwo
//i = 17 ThreadTwo
//i = 18 ThreadTwo
//i = 19 ThreadTwo
//i = 20 ThreadTwo
//i = 9 ThreadOne
//i = 10 ThreadOne
//i = 11 ThreadOne
//i = 12 ThreadOne
//i = 13 ThreadOne
//i = 14 ThreadOne
//i = 15 ThreadOne
//i = 16 ThreadOne
//i = 17 ThreadOne
//i = 18 ThreadOne
//i = 19 ThreadOne
//i = 20 ThreadOne
