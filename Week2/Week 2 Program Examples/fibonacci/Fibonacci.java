// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class illustrates four different techniques for generating the
// sequence of Fibonacci numbers. fibonacci0 uses iteration. fibonacci1
// uses recursion that involves considerable duplication of effort. fibonacci2
// uses recursion but passes in additional parameters to avoid code duplication.
// fibonacci3 uses recursion but implements a dynamic programming technique
// that saves previous results to minimize the duplication of effort.

package fibonacci;

import java.util.*;

class Fibonacci
{
	private static int counter;
	
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int n = stdin.nextInt();
		counter = 0;
		int fibonacci_0 = fibonacci0(n);
		System.out.println("Iterative Fibonacci = " + fibonacci_0 + 
			" Counter = " + counter);
		counter = 0;
		int fibonacci_1 = fibonacci1(n);
		System.out.println("Recursive Fibonacci = " + fibonacci_1 +
			" Counter = " + counter);
		counter = 0;
		int fibonacci_2 = fibonacci2(n);
		System.out.println("Tail Recursive Fibonacci = " + fibonacci_2 + 
			" Counter = " + counter);
		counter = 0;
		int fibonacci_3 = fibonacci3(n);
		System.out.println("Dynamic Programming Recursive Fibonacci = " +
			fibonacci_3 + " Counter = " + counter);
	}

	private static int fibonacci0(int n)
	{
		int previous = 0, current = 1, next;
		for (int i = 1; i <= n; i++)
		{
			counter++;
			next = previous + current;
			previous = current;
			current = next;
		}
		return previous;
	}

	private static int fibonacci1(int n)
	{
		counter++;
		if (n <= 1)
			return n;
		return fibonacci1(n - 1) + fibonacci1(n - 2);
	}

	private static int fibonacci2(int n)
	{
		if (n <= 1)
			return n;
		return fibonacci2(n, 0, 1);
	}

	private static int fibonacci2(int n, int previous, int current)
	{
		counter++;
		int next = previous + current;
		if (n == 0)
			return previous;
		return fibonacci2(n - 1, current, next);
	}

	private static int fibonacci3(int n)
	{
		ArrayList<Integer> list = new ArrayList();
		list.add(0);
		list.add(1);
		return fibonacci3(n, list);
	}

	private static int fibonacci3(int n, ArrayList<Integer> list)
	{
		counter++;
		if (n <= 1)
			return n;
		if (list.size() > n)
			return list.get(n);
		int next = fibonacci3(n - 1, list) + fibonacci3(n - 2, list);
		list.add(next);
		return next;
	}
}