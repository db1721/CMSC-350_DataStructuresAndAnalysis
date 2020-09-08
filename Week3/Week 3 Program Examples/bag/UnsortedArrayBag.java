// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a bag implemented with an unsorted array.

package bag;

import collection.*;

public class UnsortedArrayBag<T> extends UnsortedArrayCollection<T> 
	implements BagInterface<T>
{
	@Override
	public int count(T item)
	{
		int count = 1;
		int location = find(item);
		if (location < 0)
			count--;
		else
			while (location < size && item.equals(array[location++]))
				count++;
		return count;
	}

	@Override
	public int removeAll(T item)
	{
		int count = 1;
		int location = find(item);
		if (location < 0)
			count--;
		else
			while (location < size && item.equals(array[location++]))
			{
				array[location] = array[--size];
				count++;
			}
		return count;
	}
}
