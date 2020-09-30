package BeckProject3;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/* File: Project 3 - GUI
 * Author: Dan Beck
 * Date: September 29, 2020
 * Purpose: Class that generates the GUI and passes parameters to 
 * 			other classes.
 */

public class GUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField input = new JTextField(40);
	private JTextField output = new JTextField(40);
	private static BinaryTree categories;
	
	public static void main(String[] args) 
	{
		// Executes the program
		GUI createFrame = new GUI();
		createFrame.setVisible(true);
	}//End Main
	
	public GUI() 
	{
		/******************************************************************************* 
	     * DESCRIPTION: Constructor that generates the frame
	     * 1. Default settings
	     * Layers:
	     * 2. Input Field
	     * 3. Buttons
	     * 4. Output Field
	     ******************************************************************************/
		/******************************************************************************* 
	     * DESCRIPTION: 1. Default Settings
	     * A. Title
	     * B. Size
	     * C. Layout
	     * D. Default Settings
	     ******************************************************************************/
		//A. Title
		super("Binary Tree Categorizer");
		
		//B. Size
		setSize(800, 200);
		setLocationRelativeTo(null);
		
		//C. Layout
		//For this GUI, three levels 3x1 (input text, buttons and output text)
		setLayout(new GridLayout(3, 1));
		
		//D. Default settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		/******************************************************************************* 
	     * DESCRIPTION: 2. Input Field
	     ******************************************************************************/
		JComponent[] inputText = 
			{
					new JLabel("Enter Tree: "), input
			};
		flowPanelCreator(inputText);
		
		/******************************************************************************* 
	     * DESCRIPTION: 3. Buttons
	     * Creates the buttons laterally in order from left to right
	     ******************************************************************************/
		JButton[] buttons = 
			{
					new JButton("Make Tree"), 
					new JButton("Is Balanced?"),
					new JButton("Is Full?"), 
					new JButton("Is Proper?"), 
					new JButton("Height"),
					new JButton("Nodes"), 
					new JButton("In Order")
			};
		flowPanelCreator(buttons);
		addActionListeners(buttons);
		
		/******************************************************************************* 
	     * DESCRIPTION: 4. Output Field
	     ******************************************************************************/
		JComponent[] outputText = 
			{
					new JLabel("Output: "), output
			};
		flowPanelCreator(outputText);
		output.setEditable(false);
	}//end public GUI()
	
	/******************************************************************************* 
     * DESCRIPTION: Creates a flow panel from array of panelObjects
     ******************************************************************************/
	private void flowPanelCreator(JComponent[] panelObjects) 
	{
		JPanel jp = new JPanel(new FlowLayout());
		
		for (Component panelObject: panelObjects) 
		{ 
			jp.add(panelObject); 
		}//end for (Component panelObject: panelObjects)
		
		add(jp);
	}//end private void flowPanelCreator(JComponent[] panelObjects)
	
	/******************************************************************************* 
     * DESCRIPTION: Method that adds ActionListener to panel's buttons
     ******************************************************************************/
	private void addActionListeners (JButton[] buttons)
	{
		for (JButton button: buttons)
		{
			button.addActionListener(panelListener);
		}//end for (JButton button: buttons)
	}//end private void addActionListeners (JButton[] buttons)
	
	/******************************************************************************* 
     * DESCRIPTION: What the ActionListener performs for each button
     ******************************************************************************/
	private final ActionListener panelListener = event ->
	{
		try 
		{
			switch ((event.getActionCommand()))
			{
			case "Make Tree":
				categories = new BinaryTree(input.getText());
				output.setText(categories.toString());
				break;
			case "Is Balanced?":
				output.setText(String.valueOf(categories.isBalanced()));
				break;
			case "Is Full?":
				output.setText(String.valueOf(categories.isFull()));
				break;
			case "Is Proper?":
				output.setText(String.valueOf(categories.isProper()));
				break;
			case "Height":
				output.setText(String.valueOf(categories.height()));
				break;
			case "Nodes":
				output.setText(String.valueOf(categories.nodes()));
				break;
			case "Inorder":
				output.setText(categories.inOrder());
				break;
			}//end switch ((event.getActionCommand()))
		}//end try
		catch (InvalidTreeSyntax its) 
		{
			JOptionPane.showMessageDialog(getParent(),its.getMessage());
		}//end catch (InvalidTreeSyntax its) 
		catch (IndexOutOfBoundsException e) 
		{
			JOptionPane.showMessageDialog(getParent(),"No input given!");
		}//end catch (IndexOutOfBoundsException e)
	};
}//End GUI class