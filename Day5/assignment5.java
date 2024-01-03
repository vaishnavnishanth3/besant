/*   [Simple Interest amount= Principle amount * Rate of interest * Time period]    */

import java.util.Scanner;
public class assignment5 
{
    public static void main(String [] args)
    {
        try(Scanner sc = new Scanner (System.in))  
        {
            System.out.print("Enter the Principle amount: ");
            double a = sc.nextInt();
            System.out.print("Enter the Rate of Interest (in percentage): ");
            double b = sc.nextInt();
            System.out.print("Enter the Time period: ");
            double c = sc.nextInt();
            double si = a*(b/100)*c;  // Simple Interest calculation
            System.out.print("The Simple Interest is " + si);
        }
    }
}
