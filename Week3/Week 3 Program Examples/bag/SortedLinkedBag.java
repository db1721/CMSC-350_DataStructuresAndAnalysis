// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a bag implemented with a sorted singly linked list.

package bag;

import collection.*;

public class SortedLinkedBag<T extends Comparable<T>>
	extends SortedLinkedCollection<T> implements SortedBagInterface<T>
{
	@Override
	public int count(T element)
	{
		return super.count(element);
	}

	@Override
	public int removeAll(T element)
	{
		return super.removeAll(element);
	}
}
