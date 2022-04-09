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
    }

    public void reigstraEvento() {
        v.getBtnPause().addActionListener(this);
        v.getBtnPlay().addActionListener(this);
        v.getBtnStop().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.getBtnPause()) {

        }
        if (e.getSource() == v.getBtnPlay()) {

        }
        if (e.getSource() == v.getBtnStop()) {

        }
    }
}
