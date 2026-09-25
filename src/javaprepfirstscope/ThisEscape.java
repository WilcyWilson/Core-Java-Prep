package javaprepfirstscope;

@FunctionalInterface
interface MyListener {
    void onEvent();
}

class EventSource {
    public void registerListener(MyListener listener) {
        new Thread(listener::onEvent).start();
    }
}

public class ThisEscape {
    private int id;
    private String name;

    public ThisEscape(EventSource source) {
        System.out.println("Main Thread Constructor started");

        // Registering the inner class
        // This hands a hidden reference (ThisEscape.this) to the EventSource class.
        source.registerListener(() -> {
            // Background thread executes this
            // Implicitly accessing ThisEscape.this.id and ThisEscape.this.name hidden references
            System.out.println("Background thread - Event received");
            System.out.println("Background thread Reading state: id=" + id + ", name=" + name);

            if (id == 0 || name == null) {
                System.err.println("Background Thread - Reading partially constructed object");
            }
        });

        // Simulating constructor that takes time
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Main thread finishes initialization
        this.id = 42;
        this.name = "Fully Initialized";
        System.out.println("Main Thread Constructor completely finished");
    }
}

class Main {
    static void main() {
        EventSource source = new EventSource();
        new ThisEscape(source);
    }
}

