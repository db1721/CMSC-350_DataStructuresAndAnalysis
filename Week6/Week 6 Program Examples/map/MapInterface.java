// CMSC 350 Data Structures and Analysis
// Week 6 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines the operations that are required for a map data
// structure.

package map;

public interface MapInterface<K, V>
{
	V put(K key, V value);
	V get(K key);
	V remove(K key);
	boolean contains(K key);
	boolean isEmpty();
}
