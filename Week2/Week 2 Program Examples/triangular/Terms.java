// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class stacks up the terms of triangular numbers for an arbitrary
// positive integer.

package triangular;

import java.util.*;

class Terms
{
	private static final int MAXIMUM_TERMS = 3;
	private Stack<Integer> terms = new Stack();
	private int sum = 0;
	
	public void push(Integer term)
	{
		sum += term;
		terms.push(term);
	}

	public void pop()
	{
		Integer term = terms.pop();
		sum -= term;
	}
	
	public int getSum()
	{
		return sum;
	}
	
	public boolean isFull()
	{
		return terms.size() == MAXIMUM_TERMS;
	}
	
	@Override
	public String toString()
	{
		String termString = "";

		for (Integer term: terms)
			termString += term + " ";
		return("The triangular terms of " + sum + " are " + termString);
	}
}