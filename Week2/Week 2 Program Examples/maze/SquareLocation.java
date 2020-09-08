// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines the location of the squares of the maze and the four
// operations that characterize the four directions in which a square
// can move.

package maze;

class SquareLocation
{
	private int row, col;

	public SquareLocation(int row, int col)
	{
		this.row = row;
		this.col = col;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

	public SquareLocation moveDown()
	{
		return new SquareLocation(row + 1, col);
	}

	public SquareLocation moveLeft()
	{
		return new SquareLocation(row, col - 1);
	}

	public SquareLocation moveRight()
	{
		return new SquareLocation(row, col + 1);
	}

	public SquareLocation moveUp()
	{
		return new SquareLocation(row - 1, col);
	}
}