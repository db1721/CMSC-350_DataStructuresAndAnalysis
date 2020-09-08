// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method for a program that decomposes a positive
// integer into its terms of triangular numbers.

package triangular;

public class Triangular 
{
	private Triangular()
	{
	}
	
	public static int termToIndex(int term)
	{
		return (int)((Math.sqrt(1 + 8 * term) - 1) / 2);
	}
	
	public static int indexToTerm(int index)
	{
		return (index * (index + 1)) / 2;
	}
}