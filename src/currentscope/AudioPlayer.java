package currentscope;

public class AudioPlayer implements MusicPlayer {

    @Override
    public void play(String songName) {
        System.out.println("Playing Audio " + songName);
    }

    @Override
    public void pause() {
        System.out.println("Audio Paused");
    }

    @Override
    public void log(String log) {
        System.out.printf("Audio log" + log);
    }
}

