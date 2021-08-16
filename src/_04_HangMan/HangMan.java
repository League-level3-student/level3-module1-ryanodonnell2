package _04_HangMan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	JFrame frame;
	JPanel panel;
	JPanel info;
	JLabel label;
	JLabel lives;
	JLabel words;
	String currentWord = "";
	String ShowingText = "";
	String letterFoundString = "";
	ArrayList<String> lettersFound = new ArrayList<String>();
	int WordsFound = 0;
	int wordsToReadOff = 0;
	int LivesLeft = 5;
	int guessSinceLastLetter = 0;
	int lettersLeft = 100;
	Utilities utility;
	Stack<String> wordList = new Stack<String>();
	public static void main(String[] args) {
		HangMan hangMan = new HangMan();
		hangMan.setup();
	}
	
	@SuppressWarnings("static-access")
	void setup() {
		String temp;
		temp = JOptionPane.showInputDialog("How many words do you want to guess?");
		wordsToReadOff = Integer.parseInt(temp);
		frame = new JFrame();
		panel = new JPanel();
		info = new JPanel();
		label = new JLabel();
		lives = new JLabel();
		words = new JLabel();
		utility = new Utilities();
		if(wordsToReadOff>260) {
			wordsToReadOff = 260;
		}
		for (int i = 0; i < wordsToReadOff; i++) {
			String wordToAdd = utility.readRandomLineFromFile("dictionary.txt");
			wordToAdd = wordToAdd.toUpperCase();
			if(wordList.contains(wordToAdd)) {
				i--;
			}
			else {
				wordList.add(wordToAdd);
			}
		}
		currentWord = wordList.get(wordList.size()-1);
		currentWord =currentWord.toUpperCase();
		for (int i = 0; i < currentWord.length(); i++) {
			ShowingText = ShowingText+"_";
		}
		
		LivesLeft = 5+wordsToReadOff/5;
		
		lettersLeft = currentWord.length();
		label.setText(ShowingText);
		lives.setText("Lives Left: "+LivesLeft);
		words.setText("Words Completed:"+WordsFound);
		info.add(lives);
		info.add(words);
		frame.addKeyListener(this);
		panel.add(label);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(info, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(250,100));
	}
	void EndGame(int EndReason){//1=Win,2=Ran Out Of Lives
		if(EndReason == 1) {
			JOptionPane.showInternalMessageDialog(null, "You Win!");
		}
		else {
			JOptionPane.showInternalMessageDialog(null, "You Lose");
		}
	}
	@SuppressWarnings("static-access")
	void Reset() {
		String temp = JOptionPane.showInputDialog("How many words do you want to guess?");
		wordsToReadOff = Integer.parseInt(temp);
		if(wordsToReadOff>260) {
			wordsToReadOff = 260;
		}
		for (int i = 0; i < wordsToReadOff; i++) {
			String wordToAdd = utility.readRandomLineFromFile("dictionary.txt");
			wordToAdd = wordToAdd.toUpperCase();
			if(wordList.contains(wordToAdd)) {
				i--;
			}
			else {
				wordList.add(wordToAdd);
			}
		}
		currentWord = wordList.get(wordList.size()-1);
		currentWord =currentWord.toUpperCase();
		for (int i = 0; i < currentWord.length(); i++) {
			ShowingText = ShowingText+"_";
		}
		label.setText(ShowingText);
	}
	
	void askToReset(){
		String Message = JOptionPane.showInputDialog("Do you want to play again?");
		if(Message.toLowerCase().equals("yes")) {
			Reset();
		}
		else {
			frame.dispose();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean LetterPlaced = false;
		System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
		System.out.println(currentWord);
		if(lettersLeft==0&&e.getKeyCode()==KeyEvent.VK_ENTER) {
			WordsFound++;
			wordList.pop();
			if(wordList.size()>=1) {
			currentWord = wordList.get(wordList.size()-1);
			}
			else {
				askToReset();
			}
			lettersFound.clear();
			letterFoundString = "";
			ShowingText = "";
			LivesLeft++;
			for (int i = 0; i < currentWord.length(); i++) {
				ShowingText = ShowingText+"_";
			}
			lettersLeft=100;
		}
		if(currentWord.contains(KeyEvent.getKeyText(e.getKeyCode()))) {
			
			for (int i = 0; i < currentWord.length(); i++) {
				if(Character.toString(currentWord.charAt(i)).equals(KeyEvent.getKeyText(e.getKeyCode()))&&letterFoundString.contains(KeyEvent.getKeyText(e.getKeyCode())) == false) {
				lettersFound.add(KeyEvent.getKeyText(e.getKeyCode()));
				letterFoundString = letterFoundString+KeyEvent.getKeyText(e.getKeyCode());
				}
			}
			ShowingText = "";
			lettersLeft = 0;
			for (int i = 0; i < currentWord.length(); i++) {
				LetterPlaced = false;
				for (int j = 0; j < lettersFound.size(); j++) {
					if(Character.toString(currentWord.charAt(i)).equals(lettersFound.get(j))&&!LetterPlaced) {
						ShowingText = ShowingText+lettersFound.get(j);
						LetterPlaced = true;
					}
				}
				if(LetterPlaced == false) {
					ShowingText = ShowingText+"_";
					lettersLeft++;
				}
			}
			
			
			
		}
		else {
			guessSinceLastLetter++;
			if(guessSinceLastLetter >= 1) {
				guessSinceLastLetter = 0;
				LivesLeft--;
				if(LivesLeft==0) {
					askToReset();
				}
			}
		}
		label.setText(ShowingText);
		lives.setText("Lives Left: "+LivesLeft);
		words.setText("Words Completed:"+WordsFound);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
