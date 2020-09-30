// CMSC 350 Data Structures and Analysis
// Week 6 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines an operation that allow a key to be extracted.

package map;

public interface Keyed<K>
{
	K getKey();
}
