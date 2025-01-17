package model;

import java.io.File;

public class Canzone {
    private File file; // percorso
    private String lyrics; // testo da mettere in display a lato. Eventualmente metteremo un'immagine
    private String title; // titolo che viene mostrato nella JList

    public Canzone(File file, String title) {
        this.file = file;
        // this.lyrics = lyrics;
        this.title = title;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // ritorno solo il titolo così sarà più gradevole da vedere nella JList
    @Override
    public String toString() {
        return title;
    }

}
