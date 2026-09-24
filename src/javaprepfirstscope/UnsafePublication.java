package javaprepfirstscope;

public class UnsafePublication {
    private static Holder holder;

    static void main() throws InterruptedException {
        Thread one = new Thread(() ->
                holder = new Holder(42)
        );

        one.start();
        Thread two = new Thread(() -> {
            if (holder != null) {
                // The reading thread can see a partially constructed Holder
                holder.assertSanity();
            }
        });
        one.join();
        two.start();
        two.join();
    }
}

class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    // 0 != 42 can happen
    // Thread 2 executes first half of n != n
    // Since Thread 2 CPU Core hasn't synchronized with main memory, yet
    // it reads a stale value. It sees 0 default value for uninitialized int
    // While thread 2 is moving to second half of expression a cache flush occurs
    // Thread 2 CPU core finally receives updated value 42
    public void assertSanity() {
        if (n != n) { // reads the same field twice, can differ without sync
            throw new AssertionError("This statement is false");
        }
    }
}
