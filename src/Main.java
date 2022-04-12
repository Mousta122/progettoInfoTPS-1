import java.io.File;

import controller.LettoreController;
import model.Canzone;
import model.Raccolta;
import model.SongPlayer;
import view.LettoreView;

/*
 * Pavan Riccardo
 * Sow Moustapha
 * Zamuner Riccardo
 */

//  NON LEGGGE I FILE MP3

public class Main {

	public static void main(String[] args) {
		Raccolta r = loadMusic();
		SongPlayer sp = new SongPlayer();
		LettoreView v = new LettoreView();
		LettoreController c = new LettoreController(v, r, sp);
		v.setVisible(true);
	}

	public static Raccolta loadMusic() {
		Raccolta r = new Raccolta();

		// File directory = new File("musica");
		File directory = new File("musicaCompressa");
		// con questa istruzione posso iterare sulle canzoni nella directory "musica"
		for (File file : directory.listFiles()) {
			Canzone c = new Canzone(file, file.getName());
			r.aggiungiCanzone(c);
		}

		return r;
	}
}
