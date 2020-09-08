package BeckProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Font;

/* File: Project 1 - GUI
 * Author: Dan Beck
 * Date: August 29, 2020
 * Purpose: Class that generates the GUI and passes parameters to 
 * 			other classes.
 */

public class GUI
{
	public GUI() 
	{
		//***************Frame******************
		
		//Generates the JFrame
		JFrame frame = new JFrame();
		frame.setBounds(new Rectangle(600, 400, 450, 175));
		frame.setTitle("Expression Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//***************Text Fields******************
		
		//Generates the text field to see the results 
		JTextField resultText = new JTextField();
		resultText.setEditable(false);
		resultText.setColumns(10);
		resultText.setBounds(125, 95, 285, 20);
		frame.getContentPane().add(resultText);
		frame.setVisible(true);
			
		//Generates the text field to enter expression 
		JTextField expressionText = new JTextField();
		expressionText.setBounds(125, 10, 285, 20);
		frame.getContentPane().add(expressionText);
		expressionText.setColumns(10);
		
		
		//***************Buttons******************

		//Generates the prefix to postfix button
		JButton prefixToPostfixButton = new JButton("Prefix to Postfix");
		prefixToPostfixButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		prefixToPostfixButton.setBounds(70, 45, 130, 40);
		frame.getContentPane().add(prefixToPostfixButton);
		prefixToPostfixButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String expression = expressionText.getText();
					preToPost preTp = new preToPost();
					resultText.setText(preTp.preToPost(expression));
				}//end try
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Prefix expression!");
				}//end catch
			}//end Action Performed
		});//addActionListener

		//Generates the postfix to prefix button
		JButton postfixToPrefixButton = new JButton("Postfix to Prefix");
		postfixToPrefixButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		postfixToPrefixButton.setBounds(230, 45, 130, 40);
		frame.getContentPane().add(postfixToPrefixButton);
		postfixToPrefixButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String expression = expressionText.getText();
					postToPre postTp = new postToPre();
					resultText.setText(postTp.postToPre(expression));
				}//end try
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Postfix expression!");
				}//end catch
			}//end Action Performed
		});//addActionListener

		//***************Labels******************
		//Generates the results label
		JLabel resultLabel = new JLabel("Result:");
		resultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		resultLabel.setBounds(70, 95, 55, 20);
		frame.getContentPane().add(resultLabel);
		
		//Generates the Enter Expression label
		JLabel enterExpressionLabel = new JLabel("Enter Expression:");
		enterExpressionLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		enterExpressionLabel.setBounds(10, 10, 120, 20);
		frame.getContentPane().add(enterExpressionLabel);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new GUI();
	}//End Main
}//End GUI class
