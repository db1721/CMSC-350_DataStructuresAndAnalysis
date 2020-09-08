// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a first-in first-out queue implemented with a singly
// linked list.

package fifo;

import queue.*;

public class LinkedQueue<T> implements QueueInterface<T>
{
	private static class Node<T>
	{
		T data;
		Node<T> next;
	}
	private Node<T> front, back;

	@Override
	public void enqueue(T item)
	{
		Node<T> newBack = new Node();
		newBack.data = item;
		if (back == null)
			front = newBack;
		else
			back.next = newBack;
		back = newBack;
	}
	@Override
	public T dequeue() throws QueueEmpty
	{
		T item = front.data;
		if (isEmpty())
			throw new QueueEmpty();
		front = front.next;
		if (front == null)
			back = null;
		return item;
	}
	@Override
	public boolean isEmpty()
	{	
		return back == null;
	}
}
