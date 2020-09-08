// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a checked exception that is thrown when the goal square
// is reached in the maze of squares.

package maze;

class GoalReached extends Exception
{
	private SquareLocation location;

	public GoalReached(SquareLocation location)
	{
		this.location = location;
	}

	public SquareLocation getLocation()
	{
		return location;
	}
}
