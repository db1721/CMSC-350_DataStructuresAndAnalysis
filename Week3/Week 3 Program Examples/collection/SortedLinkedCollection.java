// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a collection implemented with a sorted singly
// linked list.

package collection;

public class SortedLinkedCollection<T extends Comparable<T>> implements
	SortedCollectionInterface<T>
{
	private static class Node<T>
	{
		T element;
		Node<T> next;
	}
	private Node<T> head, previous, current;
	
	@Override
	public boolean add(T element)
	{
		return add(element, true);
	}

	@Override
	public boolean remove(T element)
	{
		if (!contains(element))
			return false;
		splice(current.next);
		return true;
	}

	@Override
	public boolean contains(T element)
	{
		previous = null;
		current = head;
		while (current != null && element.compareTo(current.element) >= 0)
		{
			if (element.equals(current.element))
				return true;
			previous = current;
			current = current.next;
		}
		return false;
	}

	protected int count(T element)
	{
		int count = 0;
		current = head;
		while (current != null && element.compareTo(current.element) >= 0)
		{
			if (element.equals(current.element))
				count++;
			current = current.next;
		}
		return count;
	}

	protected int removeAll(T element)
	{
		if (!contains(element))
			return 0;
		int count = 0;
		while (current != null && element.equals(current.element))
		{
			count++;
			current = current.next;
		}
		splice(current);
		return count;
	}

	protected boolean add(T element, boolean allowDuplicates)
	{
		if (contains(element) && !allowDuplicates)
			return false;
		Node<T> newNode = new Node();
		newNode.element = element;
		newNode.next = current;
		splice(newNode);
		return true;
	}

	private void splice(Node<T> node)
	{
		if (previous == null)
			head = node;
		else
			previous.next = node;	
	}
	
	public void display()
	{
		Node<T> current = head;
		while (current != null)
		{
			System.out.print(current.element + " ");
			current = current.next;
		}
		System.out.println();
	}
}