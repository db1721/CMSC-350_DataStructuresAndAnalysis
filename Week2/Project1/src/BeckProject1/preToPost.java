package BeckProject1;

import java.util.Stack;
import java.util.StringTokenizer;

/* File: Project 1
 * Author: Dan Beck
 * Date: August 29, 2020
 * Purpose: Class that receives Prefix expression and converts it
 * 			to a Postfix expression.
 */

class preToPost
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

	//Converts Prefix to Postfix
	String preToPost(String convert) 
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
		
		//tokenize the string containing the prefix expression
		StringTokenizer st = new StringTokenizer(convert);

		//two stacks to perform the conversions
		Stack<String> rs = new Stack<String>(); 
		Stack<String> s = new Stack<String>();

		//read the tokens 
		while (st.hasMoreTokens() == true)  
		{ 
			rs.push(st.nextToken());
		}//end while (st.hasMoreTokens() == true) 

		while (rs.empty() == false)
		{
			String check = rs.pop();

			// check if symbol is operator 
			if (isOperator(check) == true)
			{ 
				// pop two operands from stack 
				String n1 = s.peek(); s.pop(); 
				String n2 = s.peek(); s.pop(); 

				// concats the operands and operator 
				String makeNew = n1 + n2 + check; 

				// Push makeNew back to stack 
				s.push(makeNew + " "); 
			}//end if (isOperator(check) == true)
			
			// if symbol is an operand 
			else
			{ 
				//push the operand to the stack 
				s.push(check + " "); 
			}//end else
		}//end while (rs.empty() == false)

		//shows the stack containing only the Postfix expression 
		return s.peek(); 
	}//end String preToPost(String pre_exp)
}// end class preToPost

