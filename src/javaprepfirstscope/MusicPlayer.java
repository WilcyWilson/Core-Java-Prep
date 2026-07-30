package javaprepfirstscope;

public interface MusicPlayer {
    int SIZE = 100; //implicitly static and final

    void play(String songName);

    void pause();

    // Add method to old interfaces so that it doesn't need to overridden everywhere
    default void log(String message) {
        System.out.println(message);
    }

    static void exit() {
        System.out.println("\nExiting");
    }
}

