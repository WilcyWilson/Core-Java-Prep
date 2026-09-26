package javaprepfirstscope;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ThreadSafeCollectionSafePublication {
    private final Map<String, Object> map = new ConcurrentHashMap<>();

    public void publishObject() {
        Object expensiveObject = new Object();
        // The put() method establishes the happens before edge
        map.put("key1", expensiveObject);
    }

    public Object retrieveObject() {
        // Any thread reading this will see the fully constructed object
        return map.get("key1");
    }

    // Safe Publication vs Synchronization

    // ConcurrentHashMap does not force Thread 2 to pause and wait for Thread 1 to insert the value first
    // So, starting t2.start() right after t.start() can lead to retriveObject() being called first
    // which can return a null value

    // What ConcurrentHashMap makes sure is Thread 2 reads the object from the map, thread 2 is
    // guaranteed to see the object in a fully constructed state. It will not see partial writes,
    // uninitialized fields, or a stale cached null caused by memory reordering
    static void main() throws InterruptedException {
        ThreadSafeCollectionSafePublication threadSafeCollectionSafePublication = new ThreadSafeCollectionSafePublication();
        CountDownLatch latch = new CountDownLatch(1); // Thread Coordination
        // One time gate. Forces one or more threads to wait until other threads complete an event

        Thread t = new Thread(() -> {
            threadSafeCollectionSafePublication.publishObject();
            latch.countDown(); // Signals that the publication is complete
            // Thread pauses execution and waits since the count i greater than 0.
        });
        Thread t2 = new Thread(() -> {
            try {
                // When thread 1 completes its work, it calls latch.countDown(), counter decrements to 0
                // All threads waiting at latch.await() wakes up instantly and resume execution
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadSafeCollectionSafePublication.retrieveObject());
        }
        );
        t.start();
        t2.start();
        t.join();
        t2.join();
    }
}
