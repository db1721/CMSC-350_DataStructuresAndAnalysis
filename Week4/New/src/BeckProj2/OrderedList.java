package BeckProj2;

/* File: Project 2 - OrderedList Class
 * Author: Dan Beck
 * Date: September 15, 2020
 * Purpose: Scans the ordered list and compares values to check how the list is sorted
 */

import java.util.List;

/******************************************************************************* 
 * DESCRIPTION: OrderedList 
 * Scans the ordered list and compares values to check how the list is sorted
 ******************************************************************************/
public class OrderedList 
{
    public static <T extends Comparable<? super T>> boolean checkSorted(List<T> list)
    {
        boolean listSorted = true;
        for (int i = list.size() - 1; i > 0; i--) 
        {
            T current = list.get(i);
            if (!checkSorted(list, current)) 
            {
                listSorted = false;
            }//end if (!checkSorted(list, current))
        }//end for (int i = list.size() - 1; i > 0; i--)

        return listSorted;
    }//end <T extends Comparable<? super T>> boolean checkSorted(List<T> list)

    private static <T extends Comparable<? super T>> boolean checkSorted(List<T> list, T current) 
    {
        //set values to be compared
        T valueOne = list.get(list.indexOf(current));
        T valueTwo = list.get(list.indexOf(current) - 1);

        if (valueTwo != null) 
        {
            return valueOne.compareTo(valueTwo) >= 0;
        }//end if (nextValue != null)
        return true;
    }//end <T extends Comparable<? super T>> boolean checkSorted(List<T> list, T current)
}//end class OrderedList