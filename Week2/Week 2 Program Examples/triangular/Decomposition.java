// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains the main method for a program that decomposes a positive
// integer into its terms of triangular numbers.

package triangular;

import java.util.*;

public class Decomposition
{
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int number;
		Terms terms;
		while (true)
		{
			System.out.print("Enter a positive integer: ");
			number = stdin.nextInt();
			if (number <= 0)
				return;
			terms = new Terms();
			termDecomposition(number, number, terms);
			System.out.println(terms);
		}
	}

	private static boolean termDecomposition(int number, int remainder, 
		Terms terms)
	{
		if (terms.isFull())
			return false;
		int maxIndex = Triangular.termToIndex(remainder);
		for (int index = maxIndex; index > 0; index--)
		{
			int term = Triangular.indexToTerm(index);
			terms.push(term);
			if (terms.getSum() == number || termDecomposition(number, 
				remainder - term, terms))
				return true;
//		  System.out.println("Backtracking: " + terms);
			terms.pop();
		}
		return false;
	}
}