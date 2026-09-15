package javaprepfirstscope;

public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        double currentBalance = balance;
        try {
            Thread.sleep(10); // The OS Swaps to Thread Two/Thread One
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Thread One wakes up unaware of Thread Two work and overwrites its work
        // balance = 0 + 100  ThreadTwo/ThreadOne calculates
        // balance = 0 + 100 ThreadOne/Thread wakes up from sleep and has no idea that value of balance has changed
        balance = currentBalance + amount;
        System.out.println(balance + " = " + Thread
                .currentThread()
                .getName());
    }

    public synchronized void depositSynchronized(double amount) {
        double currentBalance = balance;
        try {
            Thread.sleep(10); // The OS won't Swap to Thread Two/Thread One in this case since this is synchronized
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        balance = currentBalance + amount;
        System.out.println(balance + " = " + Thread
                .currentThread()
                .getName());
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        Runnable runnable = () -> {
            double deposit = 100.00;
            System.out.println(Thread
                    .currentThread()
                    .getName() + " deposited " + deposit);
            bankAccount.deposit(deposit);
        };
        Thread t1 = new Thread(runnable, "ThreadOne");
        Thread t2 = new Thread(runnable, "ThreadTwo");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(bankAccount.getBalance());

        System.out.println();
        System.out.println("Synchronized:");
        BankAccount bankAccount2 = new BankAccount();
        Runnable runnableSynchronized = () -> {
            double deposit = 100.00;
            System.out.println(Thread
                    .currentThread()
                    .getName() + " deposited " + deposit);
            bankAccount2.depositSynchronized(deposit);
        };
        Thread t1S = new Thread(runnableSynchronized, "ThreadOneS");
        Thread t2S = new Thread(runnableSynchronized, "ThreadTwoS");
        t1S.start();
        t2S.start();
        t1S.join();
        t2S.join();
        System.out.println(bankAccount2.getBalance());
    }
}
