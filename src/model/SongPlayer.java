package model;

import javax.sound.sampled.*;

public class SongPlayer {
    private Canzone song;
    private Clip clip; // attributo necessario per far partire l'audio
    private AudioInputStream audioStream; // attributo necessario per far partire l'audio
    private String status; // lo utilizzo per far capire al controller che cosa sta facendo il SongPlayer

    public SongPlayer() {
        // this(null);
        this.song = null;
        this.clip = null;
        this.status = "stop";
    }

    public SongPlayer(Canzone song) {
        this.song = song;
        clip = null;
        this.status = "stop";
    }

    public void changeSong(Canzone song) {
        this.stop();
        this.song = song;
        play();
    }

    // catcho subito le eccezioni al posto di lanciarle
    public void play() {
        try {
            audioStream = AudioSystem.getAudioInputStream(song.getFile());
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.setFramePosition(0);
            clip.start();
            setStatus("play");
        } catch (Exception e) {
            System.out.println("Error playing the song: " + e);
        }

    }

    public void stop() {
        // controllare che clip != null è necessario per evitare eventuali
        // NullPointerException
        if (clip != null) {
            clip.stop();
            clip = null;

            setStatus("stop");
        }
    }

    public void pause() {
        if (clip != null) {
            // non c'è bisogno di particolari istruzioni perchè quando viene fermata una
            // clip, essa automaticamente si salva dove si era fermata, e quindi sa da dove
            // ripartire, senza dover fare altro
            clip.stop();

            setStatus("pause");
        }
    }

    public void resume() {
        if (clip != null) {
            // non c'è bisogno di particolari istruzioni perchè quando viene fermata una
            // clip, essa automaticamente si salva dove si era fermata, e quindi sa da dove
            // ripartire, senza dover fare altro
            clip.start();

            setStatus("play");
        }
    }

    public void restart() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();

            setStatus("play");
        }
    }

    private int getTotalTime() {
        if (clip == null) {
            // eccezione
            return 0;
        } else {
            return (int) (clip.getMicrosecondLength() / 1000);
        }
    }

    public int getElapsedTimePercentage() {
        int total = getTotalTime();

        if (total == 0) {
            // eccezione
            return 0;
        } else {
            int time = (int) (clip.getMicrosecondPosition() / 1000);
            return (100 * time) / total;
        }
    }

    public Canzone getSong() {
        return song;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
