package javaprepfirstscope;

public class SafeSingleton {
    // Prevent instruction reordering
    private static volatile SafeSingleton instance;
    private static final Object internalLock = new Object();

    public static SafeSingleton getInstance() {
        if (instance == null) { // null checking
            synchronized (internalLock) {
                if (instance == null) { // second check with locking
                    instance = new SafeSingleton(); // volatile prevents reordering
                }
            }
        }
        return instance;
    }
}
