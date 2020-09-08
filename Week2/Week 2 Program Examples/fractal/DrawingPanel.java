// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a drawing panel that recursively paints a fractal image
// of squares.

package fractal;

import java.awt.*;
import javax.swing.*;

class DrawingPanel extends JPanel 
{
	private static final int X_START = 20, Y_START = 20, SIZE = 400;
	private int maxDepth = 0;
	private boolean drawingComplete = false;
	
	public boolean incrementDepth()
	{
		maxDepth++;
		return drawingComplete;
	 }
	
	@Override
	public void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		draw(graphics, X_START, Y_START, SIZE, 0);
	}

	private void draw(Graphics graphics, int x, int y, int size, int depth) 
	{
		if (depth > maxDepth) 
			return;
		if (size == 0)
		{
			drawingComplete = true;
		}	 
		graphics.setColor(Color.BLACK);
		graphics.fillRect(x, y, size, size);
		graphics.setColor(Color.WHITE);
		graphics.drawRect(x, y, size, size);
		size /= 2;
		graphics.fillRect(x, y, size, size);
		draw(graphics, x, y, size, depth + 1);
		x += size;
		y += size;
		graphics.fillRect(x, y, size, size);
		draw(graphics, x, y, size, depth + 1);
	}
}