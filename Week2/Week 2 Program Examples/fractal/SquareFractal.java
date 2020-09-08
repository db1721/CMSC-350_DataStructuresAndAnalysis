// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method that creates the window for a drawing
// panel that recursively paints a fractal image of squares.

package fractal;

import java.awt.event.*;
import javax.swing.*;

public class SquareFractal extends JFrame implements ActionListener
{
	private static final int WINDOW_SIZE = 500, DELAY = 1000;
	private Timer timer;
	private DrawingPanel drawing = new DrawingPanel();
	
	public SquareFractal()
	{
		super("Animated Square Fractal");
		setSize(WINDOW_SIZE, WINDOW_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(drawing);
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (drawing.incrementDepth())
			timer.stop();
		drawing.repaint();
	}
	
	public static void main(String[] args)
	{
		SquareFractal window = new SquareFractal();
		window.setVisible(true);
	}
}