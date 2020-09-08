// CMSC 350 Data Structures and Analysis
// Week 3 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This interface defines a sorted bag as a bag whose components must implement
// the Comparable interface.

package bag;

public interface SortedBagInterface <T extends Comparable<T>> 
	extends BagInterface<T>
{
}
