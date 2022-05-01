package model;

import java.io.File;

public class Canzone {
    private File file; // percorso
    private String title; // titolo che viene mostrato nella JList
    private File img;

    public Canzone(File file, String title, File img) {
        this.file = file;
        this.title = title;
        this.img = img;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    // ritorno solo il titolo così sarà più gradevole da vedere nella JList
    @Override
    public String toString() {
        return title;
    }
}
