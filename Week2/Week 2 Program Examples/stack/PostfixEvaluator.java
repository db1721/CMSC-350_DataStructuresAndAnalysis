// CMSC 350 Data Structures and Analysis
// Week 2 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class contains a public method that evaluates postfix expressions
// using a linked stack.

package stack;

import java.util.*;

class PostfixEvaluator
{
	private final LinkedStack<Integer> stack = new LinkedStack();
	
	public Integer evaluateExpression(String expression) throws DivideByZero
	{
		String token;
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/() ",
			true);
		while (tokenizer.hasMoreTokens())
		{
			token = tokenizer.nextToken();
			if (Character.isDigit(token.charAt(0)))
				stack.push(Integer.parseInt(token));
			else if (!token.equals(" "))
				evaluate(stack, token);
		}
		return stack.pop();
	}

	private static void evaluate(LinkedStack<Integer> stack, String token)
	{
		int result = 0, right = stack.pop(), left = stack.pop();
		char operation = token.charAt(0);

		switch (operation)
		{
			case '+':
				result = left + right;
				break;
			case '-':
				result = left - right;
				break;
			case '*':
				result = left * right;
				break;
			case '/':
				result = left / right;
				break;
			case '%':
				result = left % right;
				break;
		}
		stack.push(result);
	}
}
