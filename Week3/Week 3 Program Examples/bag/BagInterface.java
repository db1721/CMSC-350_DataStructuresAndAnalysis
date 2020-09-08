// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines the operations that are required for a bag in
// addition to those that are inherited from the CollectionInterface.

package bag;

import collection. *;

public interface BagInterface<T> extends CollectionInterface<T>
{
	int count(T item);
	int removeAll(T item);
}
