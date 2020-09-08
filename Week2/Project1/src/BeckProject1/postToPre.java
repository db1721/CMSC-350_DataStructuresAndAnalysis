package BeckProject1;

import java.util.Stack;
import java.util.StringTokenizer;

/* File: Project 1 - postToPre
 * Author: Dan Beck
 * Date: August 29, 2020
 * Purpose: Class that receives Postfix expression and converts it
 * 			to a Prefix expression.
 */

public class postToPre 
{ 
	//function that checks if character is an operator 
	static boolean isOperator(String op)  
	{ 
		switch (op)  
		{ 
		case "+": 
		case "-": 
		case "/": 
		case "*": 
			return true; 
		}//end switch (check)  
		return false; 
	}//end static boolean isOperator(String check)

	//Converts Postfix to Prefix
	String postToPre(String convert) 
	{
		//New string to be generated
		StringBuffer newString = new StringBuffer();
		
		//Sets the first character of the new string
		newString.append(convert.charAt(0));
		
		for (int i = 1, n = convert.length(); i < n; i++) 
		{ 
			//Checks if character is a space
			if(Character.isSpaceChar(convert.charAt(i)))
			{
				newString.append(convert.charAt(i));
			}
			//checks if character is a digit with an operator before it
			else if(isOperator(String.valueOf(convert.charAt(i-1))) == true &&
					Character.isDigit(convert.charAt(i)))
			{
				newString.append(" " + convert.charAt(i));
			}
			//checks if character is a operator with a digit before it
			else if(Character.isDigit(convert.charAt(i-1)) && 
					isOperator(String.valueOf(convert.charAt(i))) == true)
			{
				newString.append(" " + convert.charAt(i));
			}
			//checks if character is an operator with an operator before it
			else if(isOperator(String.valueOf(convert.charAt(i))) == true && 
					isOperator(String.valueOf(convert.charAt(i-1))) == true)
			{
				newString.append(" " + convert.charAt(i));
			}
			//checks if character is a digit
			else if (Character.isDigit(convert.charAt(i))) 
			{
				newString.append(convert.charAt(i)); 
			}
			//Passes the character through if none others are met
			else 
			{
				newString.append(convert.charAt(i));
			}
		}//end for (int i = 0, n = convert.length(); i < n; i++) 
		
		//tokenize the string containing the postfix expression
		StringTokenizer st = new StringTokenizer(newString.toString());

		//one stack to perform the conversions
		Stack<String> s = new Stack<String>();

		
		//read tokens 
		while (st.hasMoreTokens() == true)  
		{ 
			String check = st.nextToken();

			//check if symbol is operator 
			if (isOperator(check) == true)
			{ 
				//pop two operands from stack 
				String n1 = s.peek(); s.pop(); 
				String n2 = s.peek(); s.pop(); 

				//concats the operands and operator 
				String makeNew = check + " " + n2 + n1; 

				//add makeNew to stack 
				s.push(makeNew); 
			}//end if (isOperator(check) == true)
			
			//if symbol is an operand 
			else
			{ 
				//push the operand to the stack 
				s.push(check + " "); 
			}//end else
		}//end while (st.hasMoreTokens() == true)

		//shows the stack containing only the Prefix expression 
		return s.peek(); 
	}//end String preToPost(String pre_exp)
}// end class postToPre