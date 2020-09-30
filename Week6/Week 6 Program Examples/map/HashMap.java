// CMSC 350 Data Structures and Analysis
// Week 6 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a map implemented with a hash table. It provides the 
// ability to put elements into the table, get values given the key,
// remove elements given the key and determine whether an element is in the
// table with a given key.

package map;
		
public class HashMap<K, V> implements MapInterface<K, V>
{
	private HashTable<MapEntry<K, V>> map = new HashTable();
	
	@Override
	public V put(K key, V value)
	{
		MapEntry<K, V> entry = new MapEntry(key, value);
		if (!map.contains(entry))
			map.add(entry);
		return entry.getValue();
	}

	@Override
	public V get(K key)
	{
		MapEntry<K, V> entry = map.find(new MapEntry(key, null));
		return entry.getValue();
	}

	@Override
	public V remove(K key)
	{
		MapEntry<K, V> entry = map.find(new MapEntry(key, null));
		map.remove(entry);
		return entry.getValue();
	}

	@Override
	public boolean contains(K key)
	{
		MapEntry<K, V> entry = new MapEntry(key, null);
		return map.contains(entry);
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}
}
