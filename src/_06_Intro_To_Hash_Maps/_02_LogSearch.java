package _06_Intro_To_Hash_Maps;

import javax.swing.JFrame;

import org.junit.experimental.theories.FromDataPoints;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	JFrame frame;
	JFrame List;
	JPanel list;
	JPanel panel;
	JLabel label;
	JButton add;
	JButton Search;
	JButton View;
	JButton remove;
	Map<Integer, String> log = new HashMap<Integer, String>();
	void setup() {
		frame = new JFrame();
		List = new JFrame();
		panel = new JPanel();
		list = new JPanel();
		label = new JLabel();
		add = new JButton();
		Search = new JButton();
		View = new JButton();
		remove = new JButton();
		
		add.setText("Add");
		View.setText("View");
		Search.setText("Search");
		remove.setText("Remove");
		add.addActionListener(this);
		View.addActionListener(this);
		Search.addActionListener(this);
		remove.addActionListener(this);

		
		panel.add(View);
		panel.add(add);
		panel.add(Search);
		panel.add(remove);
		list.add(label);
		List.add(list);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	void showList() {
		List = new JFrame();
		list.add(label);
		List.add(list);
		List.setSize(100, 100);
		List.setPreferredSize(new Dimension(100,400));
		List.setVisible(true);
		List.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		List.pack();
	}
	
	void setLabelTextToEveryone() {
		String text = "<html><body>";
		for (Map.Entry<Integer, String> entry : log.entrySet()) {
			text = text+"<br>"+" ID: " + entry.getKey()+" Name: "+entry.getValue();
		}
		//\r\n
		label.setText(text+"</body></html>");
	}
	
	void setLabelTextToSearch(int id){
		label.setText("ID: "+id+" Name: "+log.get(id));
	}
	
	public static void main(String[] args) {
		_02_LogSearch search = new _02_LogSearch();
		search.setup();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Search) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("What is the ID you are you searching for?"));
			if(log.containsKey(id)) {
				showList();
				setLabelTextToSearch(id);
			}
		}
		else if(e.getSource()== add) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("What is your ID?"));
			String entry = JOptionPane.showInputDialog("What is your name?");
			log.put(id, entry);
		}
		else if(e.getSource()==remove) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("What is the ID to remove?"));
			if(log.containsKey(id)) {
				JOptionPane.showMessageDialog(null, "The ID was removed!");
			}
			else {
				JOptionPane.showMessageDialog(null, "The ID was not found!");
			}
			log.remove(id);
		}
		else if(e.getSource()==View) {
			showList();
			setLabelTextToEveryone();
		}
	}
}
