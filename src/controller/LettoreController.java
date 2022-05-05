package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Raccolta;
import model.SongPlayer;
import view.LettoreView;

/**
 * @author Pavan Riccardo, Sow Moustapha, Zamuner Riccardo
 *         Classe controller che gestisce le interazioni dell'utente con
 *         l'interfaccia grafica e modifica il model di conseguenza
 */

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
        v.getBtnReplay().addActionListener(this);
        v.getList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (sp.getStatus() == "end") {
                    if (v.getList().getSelectedValue() == sp.getSong()) {
                        v.addBtnReplay();
                    } else {
                        v.removeBtnReplay();
                    }
                }
            }
        });
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
                } else {
                    sp.resume();
                }
            } else if (sp.getStatus() == "end") {
                if (v.getSelectedSong() == null) // se non ho selezionato una canzone, riparte la prima
                {
                    sp.changeSong(r.getSong(0));
                } else if (v.getSelectedSong() != sp.getSong()) {
                    sp.changeSong(v.getSelectedSong());
                }
            }
            setViewTotalTime();
            v.getLblImg().setIcon(new ImageIcon(sp.getSong().getImg().toString()));
        }
        if (e.getSource() == v.getBtnStop()) {
            /*
             * -se non sta suonando una canzone: niente
             * -altrimenti: stop + reset barra -> rimuovo la canzone dal sp
             */

            if (sp.getStatus() != "stop") {
                v.updateBarra(0);
                resetViewTime();
                v.removeBtnReplay();
                sp.stop();
            }

            v.getLblImg().setIcon(new ImageIcon("img/default.gif"));
        }
        if (e.getSource() == v.getBtnReplay()) {
            sp.setStatus("play");
            sp.restart();
            v.getLblImg().setIcon(new ImageIcon(sp.getSong().getImg().toString()));
            setViewTotalTime();
            v.removeBtnReplay();
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
                setViewTime();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                if (sp.getElapsedTimePercentage() == 100) {
                    v.updateBarra(100); // a volte si bugga e si blocca a 99, quindi meglio settarlo a mano
                    v.getLblTempo().setText(v.getLblTempoTot().getText());
                    sp.setStatus("end");
                    v.addBtnReplay();
                }
            }
        }
    }

    private void setViewTime()
    {
        int min = sp.getElapsedMinutes();
        int sec = sp.getElapsedSeconds();
        String m = "";
        String s = "";
        if(min/10 == 0) m += "0";
        if(sec/10 == 0) s += "0";
        m += min;
        s += sec; 
        v.getLblTempo().setText(m + ":" + s);
    }

    private void setViewTotalTime()
    {
        int min = sp.getTotalMinutes();
        int sec = sp.getTotalSeconds();
        String m = "";
        String s = "";
        if(min/10 == 0) m += "0";
        if(sec/10 == 0) s += "0";
        m += min;
        s += sec; 
        v.getLblTempoTot().setText(m + ":" + s);
    }

    private void resetViewTime()
    {
        v.getLblTempo().setText("00:00");
        v.getLblTempoTot().setText("00:00");
    }
}
