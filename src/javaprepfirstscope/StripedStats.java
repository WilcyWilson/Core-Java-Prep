package javaprepfirstscope;

import java.util.concurrent.Executors;

// Striped locks: Reducing the probability that two threads contend for the same lock
public class StripedStats {
    private final long[] counters;
    private final Object[] locks;

    public StripedStats(int stripes) {
        counters = new long[stripes];
        locks = new Object[stripes];
        for (int i = 0; i < stripes; i++) {
            locks[i] = new Object();
        }
    }

    public void increment(int index) {
        int stripe = Math.abs(index % locks.length);
        synchronized (locks[stripe]) {
            counters[stripe]++;
        }
    }

    static void main() {
        StripedStats stripedStats = new StripedStats(25);
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> stripedStats.increment(5));
            executor.submit(() -> stripedStats.increment(6));
        }
    }
}
