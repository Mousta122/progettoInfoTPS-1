package model;

import java.io.IOException;

import javax.sound.sampled.*;

public class SongPlayer implements Runnable {
    private Canzone song;
    private Clip clip; // attributo necessario per far partire l'audio
    private AudioInputStream audioStream;
    private String status; // lo utilizzo per far capire al controller che cosa sta facendo il SongPlayer

    public SongPlayer()
    {
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
        try {
            play();
        } catch (Exception e) {
            // TODO: gestire eccezione nel play
        }
    }

    @Override
    public void run() {
        /*
         * try {
         * play();
         * } catch (Exception e) {
         * // TODO: gestire eccezione nel play
         * }
         */
    }

    // lancio le eccezioni e le catcho nel controller, che procederà a mostrare un
    // JOptionPane
    public void play() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        audioStream = AudioSystem.getAudioInputStream(song.getFile());
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.setFramePosition(0);
        clip.start();

        setStatus("play");
    }

    public void stop() {
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
