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
		v.setVisible(true);
		LettoreController c = new LettoreController(v, r, sp);
	}

	public static Raccolta loadMusic() {
		Raccolta r = new Raccolta();

		File directory = new File("musica");
		// con questa istruzione posso iterare sulle canzoni nella directory "musica"
		for (File file : directory.listFiles()) {
			String title = file.getName();
			title = removeExt(title);
			File img = cercaImg(title);
			Canzone c = new Canzone(file, title, img);
			r.aggiungiCanzone(c);
		}

		return r;
	}

	private static File cercaImg(String title)
	{
		File directory = new File("img");

		for (File file : directory.listFiles()) {
			String s = removeExt(file.getName());
			if(s.equals(title)) return file;	
		}

		return new File("img/default.gif");
	}

	private static String removeExt(String s)
	{
		String str = "";
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == '.') return str;
			str += s.charAt(i);
		}

		return "";
	}
}
