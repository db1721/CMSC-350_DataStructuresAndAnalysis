// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a first-in first-out queue implemented with a circular
// array.

package fifo;

import queue.*;

public class CircularQueue<T> implements QueueInterface<T> 
{
	private T[] queue = (T[]) new Object[200];
	private int front = 0, back = 0, size = 0;

	@Override
	public void enqueue(T item) throws QueueFull
	{
		if (size == queue.length)
			throw new QueueFull();
		queue[back] = item;
		back = (back + 1) % queue.length;
		size++;
	}
	@Override
	public T dequeue() throws QueueEmpty
	{
		if (isEmpty())
			throw new QueueEmpty();
		T item = queue[front];
		front = (front + 1) % queue.length;
		size--;
		return item;
	}
	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}
}