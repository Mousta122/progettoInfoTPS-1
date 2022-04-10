package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void reigstraEvento() {
        v.getBtnPause().addActionListener(this);
        v.getBtnPlay().addActionListener(this);
        v.getBtnStop().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.getBtnPause()) {
            /*
             * TODO:
             * -se non sta suonando una canzone: niente
             * -altrimenti: sp.pause() + pause della barra
             */
        }
        if (e.getSource() == v.getBtnPlay()) {
            /*
             * TODO:
             * -se ho selezionato una canzone diversa da quella in corso:
             * stop + reset barra -> changeSong -> play
             * -se ho selezionato play e sto già suonando la canzone: niente
             * -se non ci sono canzoni selezionate: play della prima (oppure setto di
             * default la prima canzone nel sp)
             * -se era in pause: sp.resume() + resume della barra
             */
        }
        if (e.getSource() == v.getBtnStop()) {
            /*
             * TODO:
             * -se non sta suonando una canzone: niente
             * -altrimenti: stop + reset barra -> rimuovo la canzone dal sp
             */
        }
    }
}
