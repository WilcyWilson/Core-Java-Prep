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
        System.out.println(balance + " = " + Thread.currentThread().getName());
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        Runnable runnable = () -> {
            double deposit = 100.00;
            double withdraw = 200.00;
            System.out.println(Thread.currentThread().getName() + " deposited " + deposit);
            bankAccount.deposit(deposit);
//            bankAccount.withdraw(withdraw);
//            System.out.println(Thread.currentThread().getName() + " withdraw " + withdraw);
        };
        Thread t1 = new Thread(runnable, "ThreadOne");
        Thread t2 = new Thread(runnable, "ThreadTwo");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(bankAccount.getBalance());
    }
}
