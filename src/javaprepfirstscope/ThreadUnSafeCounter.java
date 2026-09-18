package javaprepfirstscope;


//  Thread-0    Read count = 0                  0
//  Thread-1                    Read count = 0  0

// Thread-1 reads count before Thread-0 writes back

//  Thread-0    Increment to 1                  0
//  Thread-1                    Increment to 1  0
//  Thread-0    Write count = 1                 1
//  Thread-1                    Write count = 1 1

// Two increments but count went from 0 to 1 instead of 2.
// Lost update race condition

public class ThreadUnSafeCounter {
    private int count = 0;

    public void incrementCount() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    void main() throws InterruptedException {
        Thread t1 = new Thread(this::incrementCount);
        Thread t2 = new Thread(this::incrementCount);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(getCount());
    }
}
