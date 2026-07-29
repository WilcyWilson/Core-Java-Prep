package currentscope;

public class VideoPlayer implements MusicPlayer {

    @Override
    public void play(String songName) {
        System.out.println("Playing Video " + songName);
    }

    @Override
    public void pause() {
        System.out.println("Video Paused");
    }

}

