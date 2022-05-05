package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;

import model.Canzone;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LettoreView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList<Canzone> list;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnStop;
	private JProgressBar bar;
	private Canvas can;
	private JLabel lblImg;
	private JLabel lblTempo;
	private JLabel lblTempoTot;

	@SuppressWarnings("deprecation")
	public LettoreView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 257);

		// Color c=new Color(221,124,120);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.lightGray);
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 189, 149);
		contentPane.add(scrollPane);

		list = new JList<Canzone>();
		scrollPane.setViewportView(list);

		// questo Ã¨ il metodo per caricare un'immagine o icona usando il percorso
		// relativo.
		// con il metodo commentato sotto, Ã¨ necessario usare il percorso assoluto,
		// quindi non Ã¨ ideale come soluzione
		//Icon i1 = new ImageIcon("C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/play.png");
		//Icon i2 = new ImageIcon("C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/pause.png");
		//Icon i3 = new ImageIcon("C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/stop.png");
		//Icon i5 = new ImageIcon("C:/Users/Sow Moustapha/eclipse-workspace/Java1/ProgettodiSow/src/view/img/gi.gif");
		
		Icon i1 = new ImageIcon(getClass().getResource("/view/img/play.png"));
		Icon i2 = new ImageIcon(getClass().getResource("/view/img/pause.png"));
		Icon i3 = new ImageIcon(getClass().getResource("/view/img/stop.png"));
		Icon i5 = new ImageIcon(getClass().getResource("/view/img/gi.gif"));


		btnPlay = new JButton(i1);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlay.setBounds(254, 171, 45, 34);
		btnPlay.setBackground(Color.green);
		contentPane.add(btnPlay);

		btnPause = new JButton(i2);
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPause.setBounds(309, 171, 45, 34);
		btnPause.setBackground(Color.blue);
		contentPane.add(btnPause);

		btnStop = new JButton(i3);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStop.setBounds(364, 171, 45, 34);
		btnStop.setBackground(Color.red);
		contentPane.add(btnStop);

		bar = new JProgressBar();
		bar.setBackground(new Color(211, 211, 211));
		bar.setBounds(239, 150, 189, 10);
		bar.setForeground(new Color(224, 255, 255));
		contentPane.add(bar);

		lblImg = new JLabel(i5);
		lblImg.setBounds(226, 13, 215, 126);
		contentPane.add(lblImg);

		lblTempo = new JLabel("00:00");
		lblTempo.setBounds(439, 146, 35, 14);
		contentPane.add(lblTempo);
		
		lblTempoTot = new JLabel("00:00");
		lblTempoTot.setBounds(194, 146, 35, 14);
		contentPane.add(lblTempoTot);

		this.setVisible(true);

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
	public JLabel getLblTempo() {
		return lblTempo;
	}
}