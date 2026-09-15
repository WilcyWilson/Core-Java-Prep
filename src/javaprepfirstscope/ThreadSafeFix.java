package javaprepfirstscope;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadSafeFix {

    // A single immutable thread safe formatter
    // No ThreadLocal so it is created ony once
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        int numberOfTasks = 1_000_000;
        System.out.println("Starting " + numberOfTasks + " virtual threads");

        // Executors.newVirtualThreadPerTaskExecutor creates new virtual thread for every task
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, numberOfTasks).forEach(i ->
                    executor.submit(() -> {
                        // The thread grabs one formatter object per thread because we are using ThreadLocal
                        String date = LocalDate.now().format(FORMATTER);
                    })
            );
        } // The executor waits for all threads to be finished

        System.out.println("Done");
        System.out.println("Total virtual threads run: " + numberOfTasks);
        System.out.println("Total DateTimeFormatter objects created is 1");
    }
}
