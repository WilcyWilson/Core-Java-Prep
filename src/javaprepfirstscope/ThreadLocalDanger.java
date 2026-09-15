package javaprepfirstscope;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadLocalDanger {
    // SimpleDateFormat Not Thread Safe - Solution ThreadLocal
    // If two thread tries to use same SimpleDateFormat object at the same time the data gets scrambled
    // because SimpleDateFormat is not thread safe
    // ThreadLocal says whenever a new thread needs this tool don't let them share
    // instead create a personal copied object for every single Thread
    static final AtomicInteger creationCount = new AtomicInteger(0);

    static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = ThreadLocal.withInitial(() -> {
        creationCount.incrementAndGet(); // Count every time this runs
        return new SimpleDateFormat("yyyy-MM-dd");
    });

    public static void main(String[] args) {
        int numberOfTasks = 1_000_000;
        System.out.println("Starting " + numberOfTasks + " virtual threads");

        // Executors.newVirtualThreadPerTaskExecutor creates new virtual thread for every task
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, numberOfTasks).forEach(i ->
                    executor.submit(() -> {
                        // The thread grabs one formatter object per thread because we are using ThreadLocal
                        String date = DATE_FORMAT.get().format(new Date());
                    })
            );
        } // The executor waits for all threads to be finished

        System.out.println("Done");
        System.out.println("Total virtual threads run: " + numberOfTasks);
        System.out.println("Total SimpleDateFormat objects created " + creationCount.get());
    }
}
