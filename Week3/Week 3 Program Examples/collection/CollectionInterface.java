// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines the operations that are required for a collection.

package collection;

public interface CollectionInterface<T>
{
	boolean add(T element);
	boolean remove(T element);
	boolean contains(T element);
}