// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines the 8 x 8 array of squares that define the maze.

package maze;

import java.awt.*;

class Maze
{
	private static final int UP = 20, LEFT = 20, SIZE = 25,
		SQUARES = 8;
	private static final double RATIO = .2;
	private SquareState[][] squares =
		new SquareState[SQUARES][SQUARES];
	private int currentRow, currentCol, goalRow, goalCol;

	public Maze()
	{
		for (int row = 0; row < SQUARES; row++)
			for (int col = 0; col < SQUARES; col++)
				if (Math.random() >= RATIO)
					squares[row][col] = SquareState.UNVISITED;
				else
					squares[row][col] = SquareState.BLOCKED;
		squares[0][0] = SquareState.UNVISITED;
		goalRow = (int)(Math.random() * SQUARES);
		goalCol = (int)(Math.random() * SQUARES);
		squares[goalRow][goalCol] = SquareState.GOAL;
	}

	public void clearVisits()
	{
		for (int row = 0; row < SQUARES; row++)
			for (int col = 0; col < SQUARES; col++)
				if (squares[row][col] != SquareState.BLOCKED)
					squares[row][col] = SquareState.UNVISITED;
		currentRow = currentCol = -1;
		squares[goalRow][goalCol] = SquareState.GOAL;
	}

	public static Dimension getSize()
	{
		return new Dimension(LEFT * 2 + SIZE * SQUARES,
			UP * 2 + SIZE * SQUARES);
	}

	public boolean isVisitable(SquareLocation location)
		throws GoalReached
	{
		int row = location.getRow(), col = location.getCol();

		if (row == goalRow && col == goalCol)
			throw new GoalReached(location);
		if (row < 0 || row >= SQUARES || col < 0 || col >= SQUARES
			|| squares[row][col] != SquareState.UNVISITED)
			return false;
		squares[row][col] =	SquareState.VISITED;
		return true;
	}

	public void moveTo(SquareLocation location)
	{
		int row = location.getRow(), col = location.getCol();
		if (squares[row][col] == SquareState.VISITED)
			squares[row][col] = SquareState.CURRENT_OUT;
		else
			squares[row][col] = SquareState.CURRENT_IN;
		if (currentRow >= 0 && currentCol >= 0)
			squares[currentRow][currentCol] =
				SquareState.VISITED;
		currentRow = row;
		currentCol = col;
	}

	public void paint(Graphics graphics)
	{
		for (int row = 0; row < SQUARES; row++)
			for (int col = 0; col < SQUARES; col++)
			{
				graphics.setColor(squares[row][col].getColor());
				graphics.fillRect(LEFT + col * SIZE,
					UP + row * SIZE, SIZE, SIZE);
				graphics.drawRect(LEFT, UP,
					SIZE * SQUARES,	SIZE * SQUARES);
			}
	}
}