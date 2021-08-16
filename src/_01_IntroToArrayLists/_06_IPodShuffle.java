package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements MouseListener {
	Song mp3Player;
	JFrame frame;
	JPanel panel;
	JButton suprise;
	boolean played = false;
	ArrayList<String> songDir = new ArrayList<String>();
	String[] dir = {"C:\\Users\\rpodo\\Music\\The_New_Monitors_-_08_-_Hematoma.mp3",""};
	Random r;
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.

		frame = new JFrame();
		panel = new JPanel();
		suprise = new JButton();

		panel.add(suprise);
		suprise.setText("Suprise Me!");
		suprise.addMouseListener(this);

		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		for (int i = 0; i < dir.length; i++) {
			songDir.add(dir[i]);
		}
	}

	public static void main(String[] args) {
		new _06_IPodShuffle();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(played) {
			mp3Player.stop();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==suprise) {
			r = new Random();
			mp3Player = new Song(songDir.get(r.nextInt(songDir.size()-1)));
			mp3Player.play();
			played = true;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}