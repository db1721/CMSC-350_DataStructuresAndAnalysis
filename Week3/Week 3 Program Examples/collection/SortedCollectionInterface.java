// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines a sorted collection as a collection whose 
// components must implement the Comparable interface.

package collection;

public interface SortedCollectionInterface<T extends Comparable<T>>
	extends CollectionInterface<T>
{
}
