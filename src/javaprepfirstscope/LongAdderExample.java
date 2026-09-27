package javaprepfirstscope;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
    static void main() throws InterruptedException {
        LongAdder requestCounter = new LongAdder();
        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {

            // Simulating a heavy write 10 threads, each logging 10000 requests
            for (int i = 0; i < 10; i++) {
                executorService.submit(() -> {
                    for (int j = 0; j < 10000; j++) {
                        // Threads update separate cells based on their thread hash
                        requestCounter.increment();
                    }
                });
            }

            executorService.shutdown();
            boolean finishedInTime = executorService.awaitTermination(2, TimeUnit.SECONDS);
            // The final total is computed by aggregating the internal cells

            if (finishedInTime) {
                long totalRequests = requestCounter.sum();
                System.out.println("Total Requests Processed: " + totalRequests);
            } else {
                System.out.println("Timeout Reached. Thread pool didn't finish all the tasks in given time");
            }
        }

    }
}
