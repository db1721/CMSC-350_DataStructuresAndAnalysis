// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This enumerated type defines the six different states that any square in
// the maze can be in.

package maze;

import java.awt.*;

enum SquareState
{
	UNVISITED(Color.WHITE),
	VISITED(Color.LIGHT_GRAY),
	BLOCKED(Color.BLACK),
	CURRENT_IN(Color.BLUE),
	CURRENT_OUT(Color.RED),
	GOAL(Color.YELLOW);

	private Color color;

	private SquareState(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return color;
	}
}