import java.util.Scanner;

public class assignment3 
{
    public static void  main (String [] args) 
    {
        try(Scanner sc = new Scanner (System.in))
        {
            System.out.println("");  
            System.out.print("Enter the variable 1: ");
            int a = sc.nextInt(); // variable 1
            System.out.print("Enter the variable 2: ");
            int b = sc.nextInt(); // variable 2
            System.out.println("");  
            System.out.println("Before SWAP:");
            System.out.println("The value of varibale 1: "+a);
            System.out.println("The value of varibale 2: "+b);
            int c = a;
            a = b;
            b = c;
            System.out.println("");  
            System.out.println("After SWAP using third variable");
            System.out.println("The value of variable 1: "+a);  
            System.out.println("The value of varibale 2: "+b);    
            System.out.println("");  
        }
    }
}