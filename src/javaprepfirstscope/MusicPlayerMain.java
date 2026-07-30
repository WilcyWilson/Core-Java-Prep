package javaprepfirstscope;

public class MusicPlayerMain {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new AudioPlayer();
        musicPlayer.play("Hello Hello!!!");
        musicPlayer.pause();

        // Utilizing Interface reference.
        playSomething(new VideoPlayer(), "Let it Go !!!");
        playSomething(new AudioPlayer(), "You're Welcome !!!");

        MusicPlayer.exit();
        System.out.printf("Music Player size " + MusicPlayer.SIZE);
    }

    // Polymorphism. playSomething works with any MusicPlayer
    static void playSomething(MusicPlayer musicPlayer, String songName) {
        musicPlayer.play(songName);
        musicPlayer.log(" Played Sucessfully");
    }
}

