package controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.eclipse.swt.graphics.Image;

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

	public void reigstraEvento() {
		v.getBtnPause().addActionListener(this);
		v.getBtnPlay().addActionListener(this);
		v.getBtnStop().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int x = v.getList().getSelectedIndex();

		Graphics g = v.getLblImg().getGraphics();

		if (e.getSource() == v.getBtnPause()) {
			/*
			 * TODO: -se non sta suonando una canzone: niente -altrimenti: sp.pause() +
			 * pause della barra
			 */

			if (sp.getStatus() == "play") {
				sp.pause();
			}
		}
		if (e.getSource() == v.getBtnPlay()) {

			/*
			 * TODO: -se ho selezionato play e sto giÃ  suonando la canzone: niente -se ho
			 * selezionato una canzone diversa da quella in corso: stop + reset barra ->
			 * changeSong -> play -se non ci sono canzoni selezionate: play della prima
			 * (oppure setto di default la prima canzone nel sp) -se era in pause:
			 * sp.resume() + resume della barra
			 */

			switch (x) {

			case 0:

				Icon i = new ImageIcon(getClass().getResource("/view/img/classica.jpeg"));
				//Icon i = new ImageIcon(
						//"C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/classica.jpeg");

				v.getLblImg().setIcon(i);
				break;

			case 1:

				Icon i2 = new ImageIcon(getClass().getResource("/view/img/edm.jpg"));
				//Icon i2 = new ImageIcon(
						//"C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/edm.jpg");

				v.getLblImg().setIcon(i2);

				break;
			case 2:

				Icon i3 = new ImageIcon(getClass().getResource("/view/img/rock.jpg"));
				//Icon i3 = new ImageIcon(
						//"C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/rock.jpg");

				v.getLblImg().setIcon(i3);

				break;

			case 3:

				Icon i4 = new ImageIcon(getClass().getResource("/view/img/trap.jpg"));
				//Icon i4 = new ImageIcon(
						//"C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/trap.jpg");

				v.getLblImg().setIcon(i4);

				break;
			}
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
				sp.resume();
			}
		}
		if (e.getSource() == v.getBtnStop()) {
			/*
			 * TODO: -se non sta suonando una canzone: niente -altrimenti: stop + reset
			 * barra -> rimuovo la canzone dal sp
			 */

			Icon i5 = new ImageIcon(getClass().getResource("/view/img/gi.gif"));
			//Icon i5 = new ImageIcon("C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/gi.gif");

			v.getLblImg().setIcon(i5);

			if (sp.getStatus() != "stop") {
				v.updateBarra(0);
				sp.stop();
			}
		}
	}

	public void updateBarra() {
		// non Ã¨ proprio ideale farlo andare come loop infinito perÃ² questo mi Ã¨
		// venuto in mente
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
