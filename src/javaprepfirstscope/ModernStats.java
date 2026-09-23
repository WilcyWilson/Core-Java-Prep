package javaprepfirstscope;

import java.util.concurrent.atomic.LongAdder;

// JVM already provides lock splitting under the hood
// No need for manual synchronized
public class ModernStats {
    private final LongAdder reads = new LongAdder();
    private final LongAdder writes = new LongAdder();

    public void recordRead() {
        reads.increment();
    }

    public void recordWrite() {
        writes.increment();
    }

    public long total() {
        return reads.sum() + writes.sum();
    }

    static void main() throws InterruptedException {
        ModernStats s = new ModernStats();
        Thread threadRead = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                s.recordRead();
            }
        }, "ThreadRead");
        Thread threadWrite = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                s.recordWrite();
            }
        }, "ThreadWrite");
        Thread threadTotal = new Thread(() ->
        {
            // Doesn't return exact point in time snapshot
            for (int i = 0; i < 5; i++) {
                System.out.println("Mid flight snapshot total: " + s.total());
            }
        }, "ThreadTotal");
        threadRead.start();
        threadWrite.start();
        threadTotal.start();
        threadRead.join();
        threadWrite.join();
        threadTotal.join();
        System.out.println(s.reads);
        System.out.println(s.writes);
        System.out.println(s.total());
    }
}
