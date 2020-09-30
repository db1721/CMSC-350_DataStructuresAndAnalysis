// CMSC 350 Data Structures and Analysis
// Week 6 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method that creates the GUI for the
// program that tests the HashMap class. The GUI allows the 
// user to put name ID pairs into the table, get IDs given the name,
// remove elements given the name and determine whether a name ID pair
// is in the table with a given name.

package map;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HashMapGUI extends JFrame implements ActionListener
{
	private HashMap<String, Integer> nameIDmap = new HashMap();
	private final String[] choices =
		{"", "Get", "Put", "Remove", "Contains"};
	private final JComboBox combo = new JComboBox(choices);
	private final JTextField nameText = new JTextField(10);
	private final JTextField idNumberText = new JTextField(10);
	private final JButton process = new JButton("Process Request");
	
	public HashMapGUI()
	{
		super("Hash Map Test");
		setSize(330, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2, 10, 10));
		panel.add(new JLabel(" Choose Selection: "));
		panel.add(combo);
		panel.add(new JLabel(" Name: "));
		panel.add(nameText);
		panel.add(new JLabel(" ID Number: "));
		panel.add(idNumberText);
		panel.add(new JLabel(""));
		panel.add(process);
		add(panel);
		process.addActionListener(this);
		combo.addItemListener(event ->
		{
			String choice = choices[combo.getSelectedIndex()];
			if (choice.equals(""))
				return;
			nameText.setText("");
			idNumberText.setText("");
			nameText.setEditable(!choice.equals(""));
			idNumberText.setEditable(choice.equals("Put"));
		});
		combo.setSelectedItem("");
		nameText.setEditable(false);
		idNumberText.setEditable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		String name;
		Integer idNumber;
		int menuChoice = combo.getSelectedIndex();
		try
		{
			switch (choices[menuChoice])
			{
				case "Get":
					name = nameText.getText();
					idNumber = nameIDmap.get(name);
					if (idNumber == null)
						JOptionPane.showMessageDialog(null,	
							name + " not found");
					else
						idNumberText.setText("" + idNumber);
					break;
				case "Put":
					name = nameText.getText();
					idNumber = Integer.parseInt(idNumberText.getText());
					idNumber = nameIDmap.put(name, idNumber);
					if (idNumber == null)
						JOptionPane.showMessageDialog(null,	idNumber + 
							" already in the table");
					else
						JOptionPane.showMessageDialog(null, name +
							" entered into the table");
					break;
				case "Remove":
					name = nameText.getText();
					idNumber = nameIDmap.remove(name);
					if (idNumber == null)
						JOptionPane.showMessageDialog(null,	
							name + " not found");
					else
						JOptionPane.showMessageDialog(null, name +
							" removed from the table");
					break;
				case "Contains":
					name = nameText.getText();
					if (nameIDmap.contains(name))
						JOptionPane.showMessageDialog(null,	
							"Table contains " + name);
					else
						JOptionPane.showMessageDialog(null,	
							"Table does not contain " + name);
					break;
			}
		}
		catch (NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(null,	
				"Numeric value required in position and value fields");
		}
		combo.setSelectedItem("");
	}
	
	public static void main(String[] args)
	{
		HashMapGUI window = new HashMapGUI();
		window.setVisible(true);
	}
}
