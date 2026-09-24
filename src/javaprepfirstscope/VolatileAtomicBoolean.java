package javaprepfirstscope;

import java.util.concurrent.atomic.AtomicBoolean;

public class VolatileAtomicBoolean {
    private static final AtomicBoolean ready = new AtomicBoolean(false);
    private static int number; // visibility now guaranteed

    void main() throws InterruptedException {
        new Thread(() -> {
            // System.out.println(number); // Flipping the order here will result in number = 0
            while (!ready.get()) { // volatile ready establishes happens before edge
                Thread.yield();
            }
            System.out.println(number); // Inherits visibility by transitivity. Reading it after volatile ready
        }).start();

        Thread.sleep(100);
        number = 42; // happens before ready = true
        ready.set(true);
    }
}