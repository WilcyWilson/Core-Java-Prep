package javaprepfirstscope;


@FunctionalInterface
interface MyListenerStaticFactory {
    void onEvent();
}

class EventSourceStaticFactory {
    public void registerListener(MyListenerStaticFactory listener) {
        new Thread(listener::onEvent).start();
    }
}

public class ThisEscapeFixed {
    private final int id;
    private final String name;

    private ThisEscapeFixed() {
        System.out.println("Main Thread - Constructor Started");
        // Performing initialization here
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.id = 42;
        this.name = "Fully initialization";

        // Safe construction // Safe Publication
        // GlobalUserList.add(this); // 'this' would escape too early in this case
        // this reference of the object must not be exposed to other threads
        // before the constructor completes its execution
        // do not start a new thread passing this from within the constructor

        System.out.println("Main Thread - Constructor completely finished");
    }

    private void handleEvent() {
        System.out.println("Background Thread Event received");
        System.out.println("Background Thread Reading state id=" + id + ", name=" + name);
    }

    public static ThisEscapeFixed createInstance(EventSourceStaticFactory source) {
        ThisEscapeFixed instance = new ThisEscapeFixed();
        source.registerListener(instance::handleEvent);
        return instance;
    }
}

class MainStaticFactory {
    static void main() {
        EventSourceStaticFactory source = new EventSourceStaticFactory();
        ThisEscapeFixed.createInstance(source);
    }
}
