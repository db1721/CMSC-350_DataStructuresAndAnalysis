package BeckProj2;

/* File: Project 2 - Polynomial Class
 * Author: Dan Beck
 * Date: September 15, 2020
 * Purpose: Compares the polynomials in the linked list. Iterates from highest to lowest exponent.
 * Converts the polynomial to a string.
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Polynomial implements Iterable<Polynomial.Term>, Comparable<Polynomial> 
{

	//Sets the comparator
    Comparator<Polynomial> compare;
    private Term begin;

    /******************************************************************************* 
     * DESCRIPTION: Polynomial(String fromFile)
     * Uses scanner to scan file from the original file that was selected. Splits 
     * the String into individual term nodes and creates a linked list from the 
     * extracted terms.
     ******************************************************************************/
    public Polynomial(String fromFile) 
    {
        //set head Term to null
        begin = null;

        //Creates scanner to read polynomials from file
        Scanner scan = new Scanner(fromFile);

        try 
        {
            while (scan.hasNext()) 
            {
                addTerm(scan.nextDouble(), scan.nextInt());
            }//end while (scan.hasNext())
            scan.close();
        } //end try
        catch (Exception e1) 
        {
            System.out.println(e1.getLocalizedMessage());
            throw new InvalidPolynomialSyntax("Incorrect Syntax. Check inputs!");
        }//end catch (Exception e1) 
    }
    
    /******************************************************************************* 
     * DESCRIPTION: addTerm(double coef, int ex) 
     * Checks for negative exponents
     * Sets the coefficient and exponent of the added term
     ******************************************************************************/
    public void addTerm(double coef, int ex) 
    {
        if (ex < 0) 
        {
            throw new InvalidPolynomialSyntax("Negative exponents are not allowed. Check inputs!");
        }//end if (ex < 0) 
        Term t = begin;
        if (t == null) 
        {   
        	// then Polynomial is empty
            begin = new Term(coef, ex);
            begin.next = null;
        }//end if (t == null) 
        else 
        { 
        	//find end by looping to null next link
            while (t.next != null) 
            {
                t = t.next;
            }//end while (t.next != null)
            t.next = new Term(coef, ex);
        }//end else
    }//end public void addTerm(double coef, int ex)

    /******************************************************************************* 
     * DESCRIPTION: compareTo(Polynomial comparedPolynomial)
     * Compares exponents and coefficients
     ******************************************************************************/
    @Override
    public int compareTo(Polynomial comparedPolynomial) 
    {
        Term currentTerm = this.begin;
        Term nextTerm = comparedPolynomial.begin;

        while (currentTerm != null && nextTerm != null) 
        {
            // positive if this is larger, negative otherwise
            if (currentTerm.getExponent() != nextTerm.getExponent()) 
            {
                return currentTerm.getExponent() - nextTerm.getExponent();
            }//end if (currentTerm.getExponent() != nextTerm.getExponent())
            else if (currentTerm.getCoefficient() != nextTerm.getCoefficient()) 
            {
                if (nextTerm.getCoefficient() > currentTerm.getCoefficient()) 
                {
                    return -1;
                }//end if (nextTerm.getCoefficient() > currentTerm.getCoefficient())
                else if (nextTerm.getCoefficient() < currentTerm.getCoefficient()) 
                {
                    return +1;
                }//end else if (nextTerm.getCoefficient() < currentTerm.getCoefficient())
            }//end else if (currentTerm.getCoefficient() != nextTerm.getCoefficient())
            
            //resets the values outside of the loop
            currentTerm = currentTerm.getNext();
            nextTerm = nextTerm.getNext();

        }//end while (currentTerm != null && nextTerm != null)
        
        //returns zero if both are null
        if (currentTerm == null && nextTerm == null) 
        {
            return 0;
        }//end if (currentTerm == null && nextTerm == null)
        
        //if one with more terms than other
        if (currentTerm == null) 
        {
            return -1;
        }//end if (currentTerm == null)
        else 
        {
            return +1;
        }//end else
    }

    /******************************************************************************* 
     * DESCRIPTION: compareExponents(Polynomial comparedPolynomial2) 
     * Compares 2nd set of exponents and coefficients
     ******************************************************************************/
    public int compareExponents(Polynomial comparedPolynomial2) 
    {
        Term currentTerm = this.begin;
        Term nextTerm = comparedPolynomial2.begin;

        while (currentTerm != null && nextTerm != null) 
        {
            // positive if this is larger, negative otherwise
            if (currentTerm.getExponent() != nextTerm.getExponent()) 
            {
                return currentTerm.getExponent() - nextTerm.getExponent();
            }//end if (currentTerm.getExponent() != nextTerm.getExponent())
            else if (currentTerm.getCoefficient() != nextTerm.getCoefficient()) 
            {
                if (nextTerm.getCoefficient() > currentTerm.getCoefficient()) 
                {
                    return -1;
                }//end if (nextTerm.getCoefficient() > currentTerm.getCoefficient())
                else if (nextTerm.getCoefficient() < currentTerm.getCoefficient()) 
                {
                    return +1;
                }//end else if (nextTerm.getCoefficient() < currentTerm.getCoefficient())
            }//end else if (currentTerm.getCoefficient() != nextTerm.getCoefficient())
            
            //resets the values outside of the loop
            currentTerm = currentTerm.getNext();
            nextTerm = nextTerm.getNext();

        }//end while (currentTerm != null && nextTerm != null)
        
        //returns zero if both are null
        if (currentTerm == null && nextTerm == null) 
        {
            return 0;
        }//end if (currentTerm == null && nextTerm == null)
        
        //if one with more terms than other
        if (currentTerm == null) 
        {
            return -1;
        }//end if (currentTerm == null)
        else 
        {
            return +1;
        }//end else
    }

    /******************************************************************************* 
     * DESCRIPTION: Polynomial() 
     * Calls Polynomial1 and Polynomial2 to be compared
     ******************************************************************************/
    public Polynomial() 
    {
        compare = (Polynomial polynomial1, Polynomial polynomial2) -> polynomial1.compareExponents(polynomial2);
    }//end public Polynomial() 
    
    /******************************************************************************* 
     * DESCRIPTION: Polynomial(Comparator<Polynomial> compare)
     * Constructor setting the compare variable
     ******************************************************************************/
    public Polynomial(Comparator<Polynomial> compare) 
    {
        this.compare = compare;
    }//end public Polynomial(Comparator<Polynomial> compare)

    /******************************************************************************* 
     * DESCRIPTION: Iterator<Term> iterator()
     * Generates an iterator that traverses the terms of a polynomial
     ******************************************************************************/
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public Iterator<Term> iterator() 
    {
        return new Iterator() 
        {

            private Term cur = getHead();

            @Override
            public boolean hasNext() 
            {
                return cur != null && cur.getNext() != null;
            }//end public boolean hasNext()

            @Override
            public Term next() 
            {
                Term c = cur;
                cur = cur.next;
                return c;
            }//end public Term next() 
        };//end new Iterator()
    }//end public Iterator<Term> iterator() 

    /******************************************************************************* 
     * DESCRIPTION: Polynomial
     * Uses scanner to scan file from the original file that was selected. Splits 
     * the String into individual term nodes and creates a linked list from the 
     * extracted terms
     ******************************************************************************/
    @Override
    public String toString() 
    {
        StringBuilder expressionBuild = new StringBuilder();

        //checks beginning to avoid adding symbol to begining
        if (begin.coefficient > 0) 
        {
            expressionBuild.append(begin.toString());
        }//end if (begin.coefficient > 0)
        else 
        {
            expressionBuild.append(" - ").append(begin.toString());
        }//end else

        //then check the other nodes if they are not null
        for (Term t = begin.next; t != null; t = t.next) 
        {
            if (t.coefficient < 0) 
            {
                expressionBuild.append(" - ").append(t.toString());
            } 
            else 
            {
                expressionBuild.append(" + ").append(t.toString());
            }
        }//end for (Term t = begin.next; t != null; t = t.next)
        return expressionBuild.toString();
    }//end public String toString()
    
    /******************************************************************************* 
     * DESCRIPTION: Polynomial
     * Writes the term to a string
     ******************************************************************************/
    static class Term 
    {
        private double coefficient;
        private int exponent;
        private Term next;

        private Term(double c, int e) 
        {
            coefficient = c;
            exponent = e;
            next = null;
        }//end Term(double c, int e)

        private int getExponent() 
        {
            return this.exponent;
        }//end int getExponent() 

        private double getCoefficient() 
        {
            return this.coefficient;
        }//end double getCoefficient() 

        private Term getNext() 
        {
            return next;
        }//end Term getNext()

        @Override
        public String toString() 
        {
            String termString = String.format("%.1f", Math.abs(coefficient));
            if (exponent == 0) 
            {
            	//no variable
                return termString;
            } 
            else if (exponent == 1) 
            {
            	//do not display exponent
                return termString + "x";
            } 
            else 
            { 
            	// display exponent after variable
                return termString + "x^" + exponent;
            }
        }//end public String toString() 
    }//end static class Term 
    
    /******************************************************************************* 
     * DESCRIPTION: Term getHead() 
     * Getter for the beginning of equation
     ******************************************************************************/
    private Term getHead() 
    {
        return begin;
    }//end private Term getHead()
}//end public class Polynomial implements Iterable<Polynomial.Term>, Comparable<Polynomial> 