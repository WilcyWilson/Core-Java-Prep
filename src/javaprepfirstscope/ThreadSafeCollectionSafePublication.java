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

    public Object retrieveObjectIfAbsent() {
        // Any thread reading this will see the fully constructed object
        // returns null since key2 doesn't exist
        return map.get("key2");
    }

    public void publishObjectIfAbsent() {
        Object notRepeatedObject = new Object();
        // No check then act race condition

        map.putIfAbsent("key1", notRepeatedObject);
        map.putIfAbsent("key2", notRepeatedObject);
        System.out.println("Key1" + map.get("key1"));
        System.out.println("Key2" + map.get("key2"));
    }

    // Safe Publication vs Synchronization

    // ConcurrentHashMap does not force Thread 2 to pause and wait for Thread 1 to insert the value first
    // So, starting t2.start() right after t.start() can lead to retriveObject() being called first
    // which can return a null value

    // What ConcurrentHashMap makes sure is Thread 2 reads the object from the map, thread 2 is
    // guaranteed to see the object in a fully constructed state. It will not see partial writes,
    // uninitialized fields, or a stale cached null caused by memory reordering
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCollectionSafePublication threadSafeCollectionSafePublication = new ThreadSafeCollectionSafePublication();
        CountDownLatch latch = new CountDownLatch(2); // Thread Coordination
        // One time gate. Forces one or more threads to wait until other threads complete an event

        Thread t = new Thread(() -> {
            threadSafeCollectionSafePublication.publishObject();
            latch.countDown(); // Signals that the publication is complete
            // Thread pauses execution and waits since the count i greater than 0.
        });

        Thread t3 = new Thread(() -> {
            threadSafeCollectionSafePublication.publishObjectIfAbsent();
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
            System.out.println("Key1" + threadSafeCollectionSafePublication.retrieveObject());
            System.out.println("Key1" + threadSafeCollectionSafePublication.retrieveObjectIfAbsent());
        }
        );
        t.start();
        t3.start();
        t2.start();
        t.join();
        t2.join();
        t3.join();
    }
}
