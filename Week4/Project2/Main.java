package Project2;

/* File: Project 2 - Main Class
 * Author: Dan Beck
 * Date: September 12, 2020
 * Purpose: Runs the program
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
    //sets a list to filled with the equations
    private static List<Polynomial> polyList = new ArrayList<>();

    //Executes the program
    public static void main(String[] args) 
    {
        processPolyList();
    }

    // ===============================================================================================
    // method: fromFile / returns: Arraylist
    // description: Opens a file takes a String and tokenizes it into an ArrayList
    // of of expressions
    // ===============================================================================================

    public static ArrayList<String> fromFile() 
    {
        // Create ArrayList and JFileChooser
        ArrayList<String> listOfExpressions = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();

        // Show both directories and files
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        // use current directory for ease
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) 
        {
            File file = fileChooser.getSelectedFile();
            try 
            {
                Scanner scan = new Scanner(file);
                if (file.isFile()) 
                {
                    while (scan.hasNextLine()) 
                    {
                        String singleExpression = scan.nextLine();
                        listOfExpressions.add(singleExpression);
                    }
                }
                scan.close();
            } 
            catch (NoSuchElementException nse) 
            {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File is empty!");
            } 
            catch (FileNotFoundException fnf) 
            {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File is not found!");
            }
        }
        return listOfExpressions;
    }

    // ===============================================================================================
    // method: checkWeakOrder / returns: boolean
    // description: determines if a list is in weak order (should be lambda
    // expression)
    // ===============================================================================================
    public static boolean checkWeakOrder(List<Polynomial> polyList) 
    {
        boolean isWeakOrder = true;
        Polynomial previous = polyList.get(polyList.size() - 1);
        for (int i = polyList.size() - 2; i > 0; i--) 
        {

            if (previous.compareExponents(polyList.get(i)) < 0) 
            {
                isWeakOrder = false;
            }
        }
        return isWeakOrder;
    }

    // ===============================================================================================
    // method: processPolyList / returns: void / catches: InvalidPolynomialSyntax
    // description: calls fromFile to fill a list with Polynomial objects and checks
    // list order
    // ===============================================================================================
    public static void processPolyList() 
    {
        try 
        {
            ArrayList<String> a = fromFile();
            for (String element : a) 
            {
                Polynomial p = new Polynomial(element);
                System.out.println(p);
                polyList.add(p);
            }
        } 
        catch (InvalidPolynomialSyntax ex) 
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage());
        }
        /* Call to check sorted for the Strong order check */
        System.out.println("Strong Ordered: " + OrderedList.checkSorted(polyList));
        /* Check for Weak order (exponents only) */
        System.out.println("Weak Ordered: " + checkWeakOrder(polyList));
    }
}