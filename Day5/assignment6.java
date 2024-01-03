import java.util.Scanner;
public class assignment6 
{
    public static void main (String [] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            System.out.println("");
            System.out.print("Enter the first variable: ");
            int a = sc.nextInt();
            System.out.print("Enter the second variable: ");
            int b = sc.nextInt();
            System.out.print("Enter the third variable: ");
            int c = sc.nextInt();
            System.out.println("");
            System.out.println("The sum of the three numbers is " + (a+b+c));   
        }
    } 
}
