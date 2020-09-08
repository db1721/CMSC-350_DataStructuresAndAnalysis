// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a first-in first-out queue implemented with an array.

package fifo;

import queue.*;

public class LinearQueue<T> implements QueueInterface<T>
{
	private T[] queue = (T[]) new Object[200];
	private int back = 0;

	@Override
	public void enqueue(T item) throws QueueFull
	{
		if (back == queue.length)
			throw new QueueFull();
		queue[back++] = item;
	}
	@Override
	public T dequeue() throws QueueEmpty
	{
		if (isEmpty())
			throw new QueueEmpty();
		T item = queue[0];
		for (int i = 1; i < back; i++)
			queue[i - 1] = queue[i];
		back--; 
		return item;
	}
	@Override
	public boolean isEmpty()
	{
		return back == 0;
	}
}