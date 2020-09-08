/*
 * CMIS 350 Data Structures and Analysis
 * Discussion 1 
 * Author: Bronwyn Davies
 * Date: 8/22/2020
 * Description: Write a short program that periodically compares the values of 
 * the two functions and illustrates the point at which the faster growing 
 * function overtakes the slower growing one. 
 */

public class Discussion1Davies {

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            double fOfN = (60 * Math.pow(i, 7)) + (20 * Math.pow(i, 4)) + 99;
            double gOfN = Math.pow(2, i) + 77;
            
            System.out.println("n:" + i + " " + String.format("%17.0f", fOfN) + " " + String.format("%17.0f", gOfN));
            if (gOfN > fOfN) {
                System.out.println("\n At n=" + i + " g(n) overtakes f(n)\n");
                break;
            }
        }
    }
}
