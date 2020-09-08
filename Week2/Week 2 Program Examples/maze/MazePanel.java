// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a drawing panel that paints the maze of squares.

package maze;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.JPanel;

class MazePanel extends JPanel implements ActionListener
{
	public static final int DELAY = 200;
	private Maze maze;
	private SquareLocation previousLocation = null;
	private ArrayList<SquareLocation> moves;
	private Iterator<SquareLocation> iterator;
	private Timer timer;

	public MazePanel()
	{
		maze = new Maze();
		timer = new Timer(DELAY, this);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		SquareLocation location;

		if (iterator.hasNext())
		{
			location = iterator.next();
			maze.moveTo(location);
			repaint();
		}
		else
			timer.stop();
	}

	@Override
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}

	@Override
	public Dimension getPreferredSize()
	{
		return Maze.getSize();
	}

	public void newMaze()
	{
		maze = new Maze();
		repaint();
	}

	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		maze.paint(graphics);
	}

	public void startSearch()
	{
		moves = new ArrayList();
		try
		{
			search(new SquareLocation(0, 0));
		}
		catch (GoalReached goal)
		{
			addMove(goal.getLocation());
		}
		maze.clearVisits();
		iterator = moves.iterator();
		timer.start();
	}

	private void search(SquareLocation location)
		throws GoalReached
	{
		if (maze.isVisitable(location))
		{
			addMove(location);
			search(location.moveDown());
			addMove(location);
			search(location.moveRight());
			addMove(location);
			search(location.moveUp());
			addMove(location);
			search(location.moveLeft());
			addMove(location);
		}
	}

	private void addMove(SquareLocation location)
	{
		if (!location.equals(previousLocation))
		{
			moves.add(location);
			previousLocation = location;
		}
	}
}