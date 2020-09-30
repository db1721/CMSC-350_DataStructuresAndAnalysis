// CMSC 350 Data Structures and Analysis
// Week 6 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class defines a key-value pair that allows pairs to be constructed and 
// provides operations to get and set keys and to get values.

package map;

public class MapEntry<K, V> implements Keyed<K>
{
	private final K key;
	private V value;

	public MapEntry(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey()
	{
		return key;
	}
	
	public V getValue()
	{
		return value;
	}

	public void setValue(V value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return "Key: " + key + " Value: " + value;
	}
}
