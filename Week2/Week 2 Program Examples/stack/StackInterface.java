// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines the three required operations of a LIFO stack.

package stack;

public interface StackInterface<T>
{
	void push(T item) throws StackFull;
	T pop() throws StackEmpty;
	boolean isEmpty();
}