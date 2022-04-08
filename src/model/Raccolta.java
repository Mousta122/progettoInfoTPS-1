package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Raccolta {
    private ArrayList<Canzone> canzoni = new ArrayList<>();
    private DefaultListModel<Canzone> modello = new DefaultListModel<>();

    public void aggiungiCanzone(Canzone c)
    {
        canzoni.add(c);
    }

    public DefaultListModel<Canzone> getModello()
    {
        modello.clear();
        for (Canzone canzone : canzoni) {
            modello.addElement(canzone);   
        }

        return modello;
    }
}
