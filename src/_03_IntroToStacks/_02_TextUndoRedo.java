package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<String> undo = new Stack<String>();
	String Text = "";
	public static void main(String[] args) {
		_02_TextUndoRedo run = new _02_TextUndoRedo();
		run.setup();
	}
	void setup(){
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		label.setText(Text);
		frame.addKeyListener(this);
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(200,200));
		
	}
//	String StackToString() {
//		String Message = "";
//		for (int i = 0; i < text.size()-1; i++) {
//			Message = Message +text.get(i);
//		}
//		return Message;
//	}
	@Override	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
			
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(e.getExtendedKeyCode() == KeyEvent.VK_DELETE||e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if(!Text.isEmpty()) {
						String temp = "";
						for (int i = 0; i < Text.length()-1; i++) {
							System.out.println("At:");
							System.out.println(i+1);
							System.out.println("Text Length");
							System.out.println(Text.length());
							if(i >= Text.length()-2) {
								undo.add(Character.toString(Text.charAt(i)));
								System.out.println("Undo Added!");
							}
							if(i!=Text.length()-1) {
								temp = temp + Text.charAt(i);
							}
						}
						Text = temp;
					}
				}
				else if(e.getKeyCode()==KeyEvent.VK_Z&&e.isControlDown()) {
					System.out.println("undo size");
					System.out.println(undo.size());
					Text = Text+undo.get(undo.size()-1);
					undo.pop();
				}
				else if(e.getKeyCode()!=KeyEvent.VK_CONTROL){
					System.out.println(e.getKeyCode());
					System.out.println(e.getKeyCode()!=KeyEvent.VK_BACK_SPACE);
					System.out.println(Character.toString(e.getKeyChar()));
					
					
					Text = Text+Character.toString(e.getKeyChar());
				//e.getKeyText(e.getKeyCode())
				
				}
				label.setText(Text);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
