// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method that creates the window for a drawing
// panel that displays a maze of squares.

package maze;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MazeGUI implements ActionListener
{
	private static final int GAP = 30, WIDTH = 400, HEIGHT = 300;
	private JFrame frame = new JFrame("Maze");
	private JPanel panel = new JPanel(), controls = new JPanel();
	private MazePanel mazePanel = new MazePanel();
	private JButton newMaze = new JButton("New Maze"),
		search = new JButton("Search");

	public MazeGUI()
	{
		controls.setLayout(
			new BoxLayout(controls, BoxLayout.Y_AXIS));
		controls.add(newMaze);
		controls.add(Box.createRigidArea(new Dimension(GAP, GAP)));
		controls.add(search);
		panel.add(controls);
		panel.add(mazePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		Object object = event.getSource();
		if (object == newMaze)
			mazePanel.newMaze();
		else if (object == search)
			mazePanel.startSearch();
	}

	public void initialize()
	{
		newMaze.addActionListener(this);
		search.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		MazeGUI gui = new MazeGUI();
		gui.initialize();
	}
}