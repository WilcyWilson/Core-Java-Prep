package javaprepfirstscope;

public class LockHiJackDemo {

    // Vulnerable Approach - Implicitly lock on 'this', instance of LockHiJackDemo
    public synchronized void vulnerableDeposit() {
        System.out.println(Thread.currentThread().getName() + " successfully entered vulnerableDeposit");
    }

    // Safe Approach - Locks on a private object hidden from the outside class
    // Internal lock successfully protects the class's concurrency from being hijacked
    private final Object internalLock = new Object();

    public void safeDeposit() {
        synchronized (internalLock) {
            System.out.println(Thread.currentThread().getName() + " successfully entered safeDeposit");
        }
    }

    void main() throws InterruptedException {
        LockHiJackDemo bankAccount = new LockHiJackDemo();

        System.out.println("-- Scenario 1 - Attacking the vulnerable method --");

        Thread badActor = new Thread(() -> {
            System.out.println("Bad Actor grabbing the lock on the bankAccount object...");
            synchronized ((bankAccount)) {
                System.out.println("Bad Actor holds the 'this' lock and Sleeps for 3 seconds");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Bad Actor Releases the 'this' lock");
            }
        }, "BadActor");


        // Legitimate thread trying to use the vulnerable synchronized method
        Thread legitimateUser = new Thread(() -> {
            System.out.println("LegitimateUser Trying to call vulnerableDeposit()...");
            bankAccount.vulnerableDeposit();
        }, "LegitimateUser");

        badActor.start();
        Thread.sleep(100); // Giving badActor split second to grab the lock first
        legitimateUser.start();

        // Wait for Scenario 1 to finish
        badActor.join();
        legitimateUser.join();

        System.out.println();
        System.out.println("-- Scenario 2 - Attacking the safe method --");

        //Bad Actor 2 trying to use the same trick
        Thread badActor2 = new Thread(() -> {
            System.out.println("Bad Actor 2 grabbing the lock on the bankAccount object...");
            synchronized ((bankAccount)) {
                System.out.println("Bad Actor 2 holds the 'this' lock and Sleeps for 3 seconds");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Bad Actor 2 Releases the 'this' lock");
            }
        }, "BadActor2");

        // Legitimate thread trying to use the vulnerable synchronized method
        Thread legitimateUser2 = new Thread(() -> {
            System.out.println("LegitimateUser 2 Trying to call vulnerableDeposit()...");
            bankAccount.safeDeposit();
        }, "LegitimateUser2");

        badActor2.start();
        Thread.sleep(100); // Giving badActor 2 split second to grab the lock first
        legitimateUser2.start();

        // Wait for Scenario 2 to finish before main
        badActor2.join();
        legitimateUser2.join();

    }
}
