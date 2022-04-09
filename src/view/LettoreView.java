package view;

import java.awt.Canvas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Canzone;

public class LettoreView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList<Canzone> list;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnStop;
	private JProgressBar bar;
	private Canvas can;

	public LettoreView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 189, 149);
		contentPane.add(scrollPane);

		list = new JList<Canzone>();
		scrollPane.setViewportView(list);

		// sono costretto ad usare il percorso assoluto perché con quello relativo non
		// va
		Icon i1 = new ImageIcon(
				"C:/Users/zamun/OneDrive/Documenti/GitHub/progettoInfoTPS/src/view/img/play.png");
		Icon i2 = new ImageIcon(
				"C:/Users/zamun/OneDrive/Documenti/GitHub/progettoInfoTPS/src/view/img/pause.png");
		Icon i3 = new ImageIcon(
				"C:/Users/zamun/OneDrive/Documenti/GitHub/progettoInfoTPS/src/view/img/stop.png");

		btnPlay = new JButton(i1);
		btnPlay.setBounds(27, 190, 45, 34);
		contentPane.add(btnPlay);

		btnPause = new JButton(i2);
		btnPause.setBounds(82, 190, 45, 34);
		contentPane.add(btnPause);

		btnStop = new JButton(i3);
		btnStop.setBounds(137, 190, 45, 34);
		contentPane.add(btnStop);

		bar = new JProgressBar();
		bar.setBounds(295, 190, 89, 23);
		contentPane.add(bar);

		// non funziona
		// barra();
	}

	public void barra() {

		int count = 0;

		while (count <= 100) {

			try {

				bar.setValue(count);
				Thread.sleep(1000);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			count += 10;
		}
	}

	public JList<Canzone> getList() {
		return list;
	}

	public void setList(JList<Canzone> list) {
		this.list = list;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}

	public JButton getBtnPause() {
		return btnPause;
	}

	public void setBtnPause(JButton btnPause) {
		this.btnPause = btnPause;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public void setBtnStop(JButton btnStop) {
		this.btnStop = btnStop;
	}

	public JProgressBar getBar() {
		return bar;
	}

	public void setBar(JProgressBar bar) {
		this.bar = bar;
	}

}