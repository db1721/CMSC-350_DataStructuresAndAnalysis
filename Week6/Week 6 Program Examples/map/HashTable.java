// CMSC 350 Data Structures and Analysis
// Week 6 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a hash table implemented with an array of linked lists.
// It provides the ability to add, remove and check whether an element is in 
// the table.

package map;

import collection.*;

class HashTable<T extends Keyed> implements CollectionInterface<T>
{
	private class Node<T>
	{
		T element;
		Node<T> next;
	}
	
	private static final int INITIAL_CAPACITY = 32;
	private final int capacity = INITIAL_CAPACITY;
	private final Node<T>[] hashTable = new Node[INITIAL_CAPACITY];
	private Node<T> head, previous, current;
	int index, size = 0;

	@Override
	public boolean add(T element)
	{
		if (contains(element))
			return false;
		Node<T> node = new Node();
		node.element = element;
		node.next = head;
		hashTable[index] = node;
		size++;
		return true;
	}

	@Override
	public boolean remove(T element)
	{
		if (!contains(element))
			return false;
		if (previous == null)
			hashTable[index] = current.next;
		else
			previous.next = current.next;
		size--;
		return true;
	}

	@Override
	public boolean contains(T element)
	{
		return find(element) != null;
	}
	
	public T find(T element)
	{
		index = hash(element.getKey().hashCode());
		previous = null;
		head = current = hashTable[index];
		while (current != null)
		{
			if (element.getKey().equals(current.element.getKey()))
				return current.element;
		}
		return null;
	}
	
	private int hash(int hashCode)
	{
		return supplementalHash(hashCode) & (capacity - 1);
	}
	
	private int supplementalHash(int hashCode)
	{
		hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
		return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}
}
