package BeckProj2;

/* File: Project 2 - Main Class
 * Author: Dan Beck
 * Date: September 15, 2020
 * Purpose: Executes the program. Creates an ArrayList from equations that are extracted from the file.
 * Checks if the order of the equations are weak.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main 
{
    //constructor that creates the list for the equations
    private static List<Polynomial> polynomialList = new ArrayList<>();

    /******************************************************************************* 
     * DESCRIPTION: Main
     * Executes the program
     ******************************************************************************/
    public static void main(String[] args) 
    {
        processPolynomialList();
    }//end main
    
    /******************************************************************************* 
     * DESCRIPTION: ArrayList<String> fromFile() 
     * Allows user to select file
     * Expressions from each line are stored in an Arraylist
     * Returns listOfExpressions
     ******************************************************************************/
    public static ArrayList<String> fromFile() 
    {
        // Create ArrayList for the list of expressions
        ArrayList<String> listOfExpressions = new ArrayList<>();

        //Allows user to select file and reads lines from the file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int status = fileChooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) 
        {
            File file = fileChooser.getSelectedFile();
            try 
            {
            	//scans each line. Creates one expression from each line
                Scanner scan = new Scanner(file);
                if (file.isFile()) 
                {
                	//loop to create the list
                    while (scan.hasNextLine()) 
                    {
                        String singleExpression = scan.nextLine();
                        listOfExpressions.add(singleExpression);
                    }//end while (scan.hasNextLine()) 
                }// if (file.isFile())
                scan.close();
            }//end try
            catch (NoSuchElementException nse) 
            {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The selected file is empty!");
            }//end catch (NoSuchElementException nse)
            catch (FileNotFoundException fnf) 
            {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File can not be found!");
            }//end catch (FileNotFoundException fnf)
        }//end if (status == JFileChooser.APPROVE_OPTION)
        return listOfExpressions;
    }//end public static ArrayList<String> fromFile()

    /******************************************************************************* 
     * DESCRIPTION: checkWeakOrder(List<Polynomial> polynomialList)
     * Checks if the list is in weak order
     * Calls Polynomial class
     * Returns boolean
     ******************************************************************************/
    public static boolean checkWeakOrder(List<Polynomial> polynomialList) 
    {
    	//initially set the arg to true
        boolean isWeakOrder = true;
        Polynomial p = polynomialList.get(polynomialList.size() - 1);
        
        //loop to compare 
        for (int i = polynomialList.size() - 2; i > 0; i--) 
        {
            if (p.compareExponents(polynomialList.get(i)) < 0) 
            {
                isWeakOrder = false;
            }//end if (p.compareExponents(polynomialList.get(i)) < 0) 
        }//end for (int i = polynomialList.size() - 2; i > 0; i--) 
        return isWeakOrder;
    }//end public static boolean checkWeakOrder(List<Polynomial> polynomialList) 

    /******************************************************************************* 
     * DESCRIPTION: processPolynomialList() 
     * Generates an ArrayList from the user selected file
     * Calls InvalidPolynomialSyntax class
     * Calls OrderedList class
     * Output checks if the equations are strong ordered
     * Output checks if the equations are weak ordered
     ******************************************************************************/
    public static void processPolynomialList() 
    {
        try 
        {
        	//Generates ArrayList from file
            ArrayList<String> a = fromFile();
            
            //Output start
            System.out.println("Equations:");
            
            //Loop that checks list order
            for (String element : a) 
            {
                Polynomial p = new Polynomial(element);
                System.out.println(p);
                polynomialList.add(p);
            }//end for (String element : a)
        }//end try
        catch (InvalidPolynomialSyntax ex) 
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage());
        }//end catch (InvalidPolynomialSyntax ex)
        
        if(OrderedList.checkSorted(polynomialList) == true)
        {
        	//checks if the list is strong ordered
            System.out.println("\nList is Strong Ordered");
        }//end if(OrderedList.checkSorted(polynomialList) == true)
        else if(checkWeakOrder(polynomialList) == true)
        {
        	//checks if the list is weak ordered
        	System.out.println("\nList is Weak Ordered");
        }//end else if(checkWeakOrder(polynomialList) == true)
        else 
        {
        	//checks if the list is weak ordered
        	System.out.println("\nList is Neither Weak or Strong Ordered");
        }//end else
    }//end public static void processPolynomialList() 
}//end Main class