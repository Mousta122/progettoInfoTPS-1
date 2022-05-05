package view;

import java.awt.*;

import javax.swing.*;
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
	private JLabel lblImg;
	private Icon songImage;
	private JButton btnReplay;

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

		// questo è il metodo per caricare un'immagine o icona usando il percorso
		// relativo.
		// con il metodo commentato sotto, è necessario usare il percorso assoluto,
		// quindi non è ideale come soluzione
		// Icon i1 = new ImageIcon(getClass().getResource("img/play.png"));
		Icon i1 = new ImageIcon("img/play.png");
		Icon i2 = new ImageIcon("img/pause.png");
		Icon i3 = new ImageIcon("img/stop.png");
		Icon i4 = new ImageIcon("img/replay.png");
		songImage = new ImageIcon("img/default.gif");

		/*
		 * Icon i1 = new ImageIcon(
		 * "C:/Users/Sow Moustapha/eclipse-workspace/Java1/progettoInfoTPS/src/view/img/play.png"
		 * );
		 * Icon i2 = new ImageIcon(
		 * "C:/Users/Sow Moustapha/eclipse-workspace/Java1/progettoInfoTPS/src/view/img/pause.png"
		 * );
		 * Icon i3 = new ImageIcon(
		 * "C:/Users/Sow Moustapha/eclipse-workspace/Java1/progettoInfoTPS/src/view/img/stop.png"
		 * );
		 */

		btnPlay = new JButton(i1);
		btnPlay.setBounds(244, 190, 45, 34);
		btnPlay.setBackground(Color.green);
		contentPane.add(btnPlay);

		btnPause = new JButton(i2);
		btnPause.setBounds(299, 190, 45, 34);
		btnPause.setBackground(Color.blue);
		contentPane.add(btnPause);

		btnStop = new JButton(i3);
		btnStop.setBounds(354, 190, 45, 34);
		btnStop.setBackground(Color.red);
		contentPane.add(btnStop);

		btnReplay = new JButton(i4);
		btnReplay.setBounds(244, 190, 45, 34);
		btnReplay.setBackground(Color.green);

		bar = new JProgressBar();
		bar.setBounds(244, 150, 158, 10);
		contentPane.add(bar);

		// Icon i4 = new ImageIcon(getClass().getResource("/view/img/musica.png"));
		lblImg = new JLabel(songImage);
		lblImg.setBounds(241, 13, 158, 126);
		contentPane.add(lblImg);
<<<<<<< Updated upstream
=======
		
		lblTempo = new JLabel("00:00");
		lblTempo.setBounds(200, 146, 35, 14);
		contentPane.add(lblTempo);
		
		lblTempoTot = new JLabel("00:00");
		lblTempoTot.setBounds(439, 146, 35, 14);
		contentPane.add(lblTempoTot);
>>>>>>> Stashed changes

		updateBarra(0);
	}

	public void updateBarra(int val) {
		bar.setValue(val);
	}

	public JList<Canzone> getList() {
		return list;
	}

	public void setList(JList<Canzone> list) {
		this.list = list;
	}

	public Canzone getSelectedSong() {
		return list.getSelectedValue();
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

	public JLabel getLblImg() {

		return lblImg;
	}

	public void setLblImg(JLabel lblImg) {

		this.lblImg = lblImg;
	}

	public void setSongImage(String path)
	{
		songImage = new ImageIcon(path);
	}

	public JButton getBtnReplay() {
		return btnReplay;
	}

	public void setBtnReplay(JButton btnReplay) {
		this.btnReplay = btnReplay;
	}
	
	public void addBtnReplay()
	{
		contentPane.remove(btnPlay);
		contentPane.add(btnReplay);
		contentPane.revalidate();
        validate();
        repaint();
	}

	public void removeBtnReplay()
	{
		contentPane.remove(btnReplay);
		contentPane.add(btnPlay);
		contentPane.revalidate();
        validate();
        repaint();
	}
}
