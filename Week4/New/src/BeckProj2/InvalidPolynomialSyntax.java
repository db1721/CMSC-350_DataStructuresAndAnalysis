package BeckProj2;

/* File: Project 2 - InvalidPolynomialSyntax Class
 * Author: Dan Beck
 * Date: September 15, 2020
 * Purpose:Class that creates InvalidPolynomialSyntax error to be caught in program
 */

public class InvalidPolynomialSyntax extends RuntimeException 
{
    private static final long serialVersionUID = 1L;

    InvalidPolynomialSyntax(String msg) 
    {
        super(msg);
    }//end InvalidPolynomialSyntax(String msg)
}//end class InvalidPolynomialSyntax