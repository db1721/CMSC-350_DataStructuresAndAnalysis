// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines fraction objects that can be compared. In addition
// it provides a toString method that displays the fraction reduced to
// its lowest terms.

package bag;

public class Fraction implements Comparable<Fraction>
{
	private final int numerator;
	private final int denominator;
	
	public Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public int compareTo(Fraction other)
	{
		return numerator * other.denominator - denominator * other.numerator;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Fraction))
			return false;
		return compareTo((Fraction)other) == 0;
	}
	
	@Override
	public String toString()
	{
		int gcd = Fraction.gcd(numerator, denominator);
		return numerator / gcd + "/" + denominator /gcd;
	}
	
	private static int gcd (int left, int right) 
	{
		if (right == 0)
			return left;
		else
			return gcd(right, left % right);
  }
}
