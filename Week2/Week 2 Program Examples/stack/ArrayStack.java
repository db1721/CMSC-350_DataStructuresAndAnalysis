// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a stack that implemented with an array. It throws an
// exception if a push is attempted on a full stack or a pop is attempted on
// an empty stack.

package stack;

public class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack = (T[]) new Object[200];
	private int top = 0;
  
	@Override
	public void push(T item) throws StackFull
	{
		if (top == stack.length)
			throw new StackFull();
		stack[top++] = item;
	}
	
	@Override
	public T pop() throws StackEmpty
	{
		if (isEmpty())
			throw new StackEmpty();
		return stack[--top];
	}
	
	@Override
	public boolean isEmpty()
	{
		return top == 0;
	}
}
