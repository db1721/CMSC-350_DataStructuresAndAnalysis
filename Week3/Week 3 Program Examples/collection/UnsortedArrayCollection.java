// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a collection implemented with an unsorted array.

package collection;

public class UnsortedArrayCollection<T> implements CollectionInterface<T>
{
	protected final int SIZE = 200;
	protected T[] array = (T[])new Object[SIZE];
	protected int size;
	
	@Override
	public boolean add(T element)
	{
		if (size == array.length)
			return false;
		array[size++] = element;
		return true;
	}

	@Override
	public boolean remove(T element)
	{
		int location = find(element);
		if (location < 0)
			return false;
		array[location] = array[--size];
		return true;
	}

	@Override
	public boolean contains(T element)
	{
		return find(element) >= 0;
	}

	protected int find(T element)
	{
		for (int i = 0; i < size; i++)
			if (element.equals(array[i]))
				return i;
		return -1;
	} 
}
