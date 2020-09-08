// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method that creates the GUI for the
// program that tests the SortedLinkedBag class containing fractions.
// The GUI allows fractions to be added, a single instance of a fraction
// to be removed, all instances of a fraction to be removed, and the ability
// to inquiry how many instances of a particular fraction are in the bag.

package bag;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LinkedBagGUI extends JFrame implements ActionListener
{
	private final SortedLinkedBag<Fraction> fractions = new SortedLinkedBag();
	private final String[] choices = {"Add", "Remove One", "Remove All",
		"Count"};
	private final JComboBox combo = new JComboBox(choices);
	private final JTextField fractionText = new JTextField(10);
	private final JButton process = new JButton("Process Request");
	
	public LinkedBagGUI()
	{
		super("Linked Bag of Fractions");
		setSize(325, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2, 10, 10));
		panel.add(new JLabel(" Choose Selection: "));
		panel.add(combo);
		panel.add(new JLabel(" Fraction: "));
		panel.add(fractionText);
		panel.add(new JLabel(""));
		panel.add(process);
		add(panel);
		process.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		Fraction fraction = getFraction(fractionText.getText());
		int menuChoice = combo.getSelectedIndex(), count;
		switch (choices[menuChoice])
		{
			case "Add":
				fractions.add(fraction);
				JOptionPane.showMessageDialog(null, fraction + " added");
				break;
			case "Remove One":
				if (fractions.remove(fraction))
					JOptionPane.showMessageDialog(null, fraction + " removed");
				else
					JOptionPane.showMessageDialog(null, fraction + 
						" not found");
				break;
			case "Remove All":
				count = fractions.removeAll(fraction);
				JOptionPane.showMessageDialog(null, count + 
					" copies of " + fraction + " removed");
				break;
			case "Count":
				count = fractions.count(fraction);
				JOptionPane.showMessageDialog(null, "Bag contains " + count + 
					" copies of " + fraction);
				break;
		}
	}
	
	public Fraction getFraction(String fractionString)
		throws NumberFormatException
	{
		String[] values = fractionString.split("/");
		if (values.length != 2)
			throw new NumberFormatException();
		int numerator = Integer.parseInt(values[0]);
		int denominator = Integer.parseInt(values[1]);
		return new Fraction(numerator, denominator);
	}
	
	public static void main(String[] args)
	{
		LinkedBagGUI frame = new LinkedBagGUI();
		frame.setVisible(true);
	}
}
