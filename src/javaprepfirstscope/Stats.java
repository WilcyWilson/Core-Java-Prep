package javaprepfirstscope;

// Blocked even with lock splitting
// Lock Splitting - Multiple locks guarding different variables
public class Stats {
    private long reads = 0;
    private long writes = 0;

    private final Object readLock = new Object();
    private final Object writLock = new Object();

    public void recordRead() {
        synchronized (readLock) {
            reads++;
        }
    }

    public void recordWrite() {
        synchronized (writLock) {
            writes++;
        }
    }

    // totalOps() needs both locks
    // The sum r + w can be a stale value because read or write could increment
    // between capturing r and w
    public long total() {
        long r, w;
        synchronized (readLock) {
            r = reads;
        }
        synchronized (writLock) {
            w = writes;
        }
        return r + w;
    }

    static void main() throws InterruptedException {
        Stats s = new Stats();
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
