package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.lang.model.util.ElementScanner14;
import javax.swing.ImageIcon;

import model.Raccolta;
import model.SongPlayer;
import view.LettoreView;

public class LettoreController implements ActionListener {
    private LettoreView v;
    private Raccolta r;
    private SongPlayer sp;

    public LettoreController(LettoreView v, Raccolta r, SongPlayer sp) {
        this.v = v;
        this.r = r;
        this.sp = sp;
        reigstraEvento();
        v.getList().setModel(r.getModello());
        updateBarra();
    }

    private void reigstraEvento() {
        v.getBtnPause().addActionListener(this);
        v.getBtnPlay().addActionListener(this);
        v.getBtnStop().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.getBtnPause()) {
            /*
             * -se non sta suonando una canzone: niente
             * -altrimenti: sp.pause() + pause della barra
             */

            if (sp.getStatus() == "play") {
                sp.pause();
            }
        }
        if (e.getSource() == v.getBtnPlay()) {
            /*
             * -se ho selezionato play e sto già suonando la canzone: niente
             * -se ho selezionato una canzone diversa da quella in corso:
             * stop + reset barra -> changeSong -> play
             * -se non ci sono canzoni selezionate: play della prima (oppure setto di
             * default la prima canzone nel sp)
             * -se era in pause: cambio canzone oppure sp.resume() + resume della barra
             */

            if (sp.getStatus() == "play") {
                if (v.getSelectedSong() != null && sp.getSong() != v.getSelectedSong()) {
                    sp.stop();
                    v.updateBarra(0);
                    sp.changeSong(v.getSelectedSong());
                }
            } else if (sp.getSong() == null || sp.getStatus() == "stop") {
                if (v.getSelectedSong() == null) // se non ho selezionato una canzone, parte la prima
                {
                    sp.changeSong(r.getSong(0));
                } else {
                    sp.changeSong(v.getSelectedSong());
                }
            } else if (sp.getStatus() == "pause") {
                if (v.getSelectedSong() == null) // se non ho selezionato una canzone, parte la prima
                {
                    sp.changeSong(r.getSong(0));
                } else if (v.getSelectedSong() != sp.getSong()) {
                    sp.changeSong(v.getSelectedSong());
                } else 
                {
                    sp.resume();
                }
            }

            v.getLblImg().setIcon(new ImageIcon(sp.getSong().getImg().toString()));
        }
        if (e.getSource() == v.getBtnStop()) {
            /*
             * -se non sta suonando una canzone: niente
             * -altrimenti: stop + reset barra -> rimuovo la canzone dal sp
             */

            if (sp.getStatus() != "stop") {
                v.updateBarra(0);
                sp.stop();
            }

            v.getLblImg().setIcon(new ImageIcon("img/default.gif"));
        }
    }

    public void updateBarra() {
        // non è proprio ideale farlo andare come loop infinito però questo mi è venuto
        // in mente
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            while (sp.getStatus() == "play") {
                v.updateBarra(sp.getElapsedTimePercentage());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }
    }
}
