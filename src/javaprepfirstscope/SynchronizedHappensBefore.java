package javaprepfirstscope;

public class SynchronizedHappensBefore {
    private int data = 0;
    private static final Object lock = new Object();

    // Using lock2 in readData can provide output as 0
//    private static final Object lock2 = new Object();

    // Executed by Thread One
    public void writeDate() {
        // Thread One locks Monitor M
        synchronized (lock) {
            data = 42;
        }
        // Thread One unlocks Monitor M.
        // A happens before relationship is established here for the next lock on 'monitor'
    }

    // Executed by ThreadTwo after ThreadOne finishes
    public void readData() {
        // Give ThreadOne 100 ms head start to grab the lock and write the data
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock) {
            // Because of happens-before rule JMM makes sure thread 2 will read updated value (42) and not value 0
            System.out.println(data);
        }
    }

    void main() throws InterruptedException {
        SynchronizedHappensBefore synchronizedHappensBefore = new SynchronizedHappensBefore();
        Thread threadOne = new Thread(synchronizedHappensBefore::writeDate, "ThreadOne");
        Thread threadTwo = new Thread(synchronizedHappensBefore::readData, "ThreadTwo");

        // There is no way to know which thread gets the CPU time first since Thread Two can get the CPU time first.
        // Giving threadOne the head start in this case in readData
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
    }
}
