package BeckProject3;

/* File: Project 3 - InvalidTreeSyntax Class
 * Author: Dan Beck
 * Date: September 23, 2020
 * Purpose:Class that creates InvalidTreeSyntax error to be caught in program
 */

public class InvalidTreeSyntax extends RuntimeException 
{
    private static final long serialVersionUID = 1L;

    InvalidTreeSyntax(String msg) 
    {
        super(msg);
    }//end InvalidPolynomialSyntax(String msg)
}//end class InvalidPolynomialSyntax