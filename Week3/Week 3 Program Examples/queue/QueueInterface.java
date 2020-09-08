// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines the operations that are required for a first-in
// first-out queue.

package queue;

public interface QueueInterface<T>
{
	void enqueue(T item) throws QueueFull;
	T dequeue() throws QueueEmpty;
	boolean isEmpty();
}    

