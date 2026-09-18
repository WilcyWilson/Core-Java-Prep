package javaprepfirstscope;

public class VisibilityProblem {
    // Missing volatile causes visibility problem
    private boolean running = true;

    public void stop() {
        running = false;
        System.out.println("Thread Two: Stop requested");
    }

    public void doWork() {
        System.out.println("Thread One Starting Work");

        // ThreadOne reads running into its CPU local register
        // Since its reading from cache it might never see false even though the running is set to false by Thread Two
        while (running) {
            System.out.println("Running");
        }
        System.out.println("Thread One Work Stopped");
    }

    void main() throws InterruptedException {
        VisibilityProblem sharedInstance = new VisibilityProblem();

        // Thread One executes doWork() and gets stuck in while loop
        Thread t1 = new Thread(sharedInstance::doWork, "ThreadOne");
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100); // Giving ThreadOne time to start and cache the value of running (true)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedInstance.stop();
        }, "ThreadTwo");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
