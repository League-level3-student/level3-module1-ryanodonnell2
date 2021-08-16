package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	ArrayList<String> list = new ArrayList<String>();

	void setup() {
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton();
		view = new JButton();

		panel.add(add);
		panel.add(view);
		add.setText("Add");
		view.setText("View");
		add.addActionListener(this);
		view.addActionListener(this);

		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	public static void main(String[] args) {
		new _02_GuestBook().setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String nameToAdd = JOptionPane.showInputDialog("Name?");
			list.add(nameToAdd);
		}
		else if (e.getSource() == view) {
			String message = "";
			for (int i = 0; i < list.size(); i++) {
				message = message+"Guest #"+(i+1)+": "+list.get(i)+"\n";
			}
			JOptionPane.showMessageDialog(null, message);
		}

	}

}
