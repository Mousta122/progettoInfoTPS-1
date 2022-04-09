import java.io.File;

import model.Canzone;
import model.Raccolta;
import model.SongPlayer;
import view.LettoreView;

/*
 * Pavan Riccardo
 * Sow Moustapha
 * Zamuner Riccardo
 */

public class Main {

	public static void main(String[] args) {
		Raccolta r = loadMusic();
		SongPlayer sp = new SongPlayer();
		LettoreView v = new LettoreView();
		v.setVisible(true);
	}

	public static Raccolta loadMusic() {
		Raccolta r = new Raccolta();

		File directory = new File("musica");
		// con questa istruzione posso iterare sulle canzoni nella directory "musica"
		for (File file : directory.listFiles()) {
			Canzone c = new Canzone(file, file.getName());
			r.aggiungiCanzone(c);
		}

		return r;
	}
}
