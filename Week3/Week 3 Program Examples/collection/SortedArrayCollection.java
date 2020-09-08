// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a collection implemented with a sorted array.

package collection;

public class SortedArrayCollection<T extends Comparable<T>> implements
	SortedCollectionInterface<T>
{
	protected final int SIZE = 200;
	protected T[] array = (T[])new Object[SIZE];
	protected int size;
	
	@Override
	public boolean add(T element)
	{
		if (size == array.length)
			return false;
		int i = size - 1;
		while (i >= 0 && element.compareTo(array[i]) < 0)
			array[i + 1] = array[i]; 
		array[i + 1] = element;
		size++;
		return true;
	}

	@Override
	public boolean remove(T element)
	{
		int location = find(element);
		if (location < 0)
			return false;
		for (int i = location; i < size - 1; i++)
			array[i] = array[i + 1];
		size--;
		return true;
	}

	@Override
	public boolean contains(T element)
	{
		return find(element) >= 0;
	}

	protected int find(T element)
	{
		int left = 0, right = size - 1, middle;
		while (left <= right)
		{
			middle = (left + right) / 2;
			T value = array[middle];
			if (element.equals(value))
				return middle;
			else if (element.compareTo(value) < 0)
				right = middle - 1;
			else
				left = middle + 1;
		}
		return -1;
	}
}
