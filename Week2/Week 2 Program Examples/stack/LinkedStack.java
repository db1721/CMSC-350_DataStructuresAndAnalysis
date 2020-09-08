// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a stack that implemented with a singly linked list.
// It throws an exception if a pop is attempted on an empty stack.

package stack;

public class LinkedStack<T> implements StackInterface<T>
{
	private static class Node<T>
	{
		T data;
		Node<T> previous;
	}
	private Node<T> top;

	@Override
	public void push(T item)
	{
		Node<T> newTop = new Node();
		newTop.data = item;
		newTop.previous = top;
		top = newTop;
	}
	
	@Override
	public T pop() throws StackEmpty
	{
		if (top == null)
			throw new StackEmpty();
		T item = top.data;
		top = top.previous;
		return item;
	}
	
	@Override
	public boolean isEmpty()
	{
		return top == null;
	}
}