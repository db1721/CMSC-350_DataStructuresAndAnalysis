import java.math.*;

public class Discussion1 
{

    public static void main(String[] args) 
    {
    	double a = 0;
    	double b = 0;
    	double i = 1;
    	
    	System.out.println(String.format("%-6s", " n") + String.format("%-9s", "f(n)") + String.format("%-4s", "g(n)"));
    	
    	while (a >= b)
    	{
           	System.out.println(String.format("%2.0f", i) + ". " + String.format("%6.0f", aCalc(i)) 
           		+ "    " + String.format("%5.0f", bCalc(i)));
            a = aCalc(i);
            b = bCalc(i);
            i++;
    	}
    	System.out.println("At n = " + String.format("%.0f", i) + ", f(" + String.format("%.0f", aCalc(i)) 
           		+ ") overtakes g(" + String.format("%.0f", bCalc(i)) + ")");
    }
    
    private static double aCalc(double a)
    {
        return Math.pow(a, 2) + (a *2) + 10000;
    }
    
    private static double bCalc(double b)
    {
        return Math.pow(b, 3);
    }
}