package Project2;

/* File: Project 2 - Polynomial Class
 * Author: Dan Beck
 * Date: September 12, 2020
 * Purpose: Comapares the polynomials
 */

public class InvalidPolynomialSyntax extends RuntimeException 
{
    private static final long serialVersionUID = 1L;

    InvalidPolynomialSyntax(String msg) 
    {
        super(msg);
    }//end InvalidPolynomialSyntax(String msg)
}//end class InvalidPolynomialSyntax