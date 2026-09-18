package javaprepfirstscope;

public class CheckThenAct {
    private static CheckThenAct instance;

    public static CheckThenAct getInstance() {
        if (instance == null) {             // Check
            instance = new CheckThenAct();  // Then Act Race Condition
        }
        return instance;
    }

    // Two threads can see instance == null, both create an object and one assignment overwrites the other.
    // Worse, a thread might see a partially constructed object
    // Java Memory Model (JMM) allows compilers and CPU to reorder instructions for optimization

    static void main() throws InterruptedException {
        Thread t1 = new Thread(CheckThenAct::getInstance, "ThreadOne");
        Thread t2 = new Thread(CheckThenAct::getInstance, "ThreadTwo");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
