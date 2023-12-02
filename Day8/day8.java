// Day8
import java.util.Scanner;
public class day8 
{
    public static void main(String[] args) 
    {
        try(Scanner sc = new Scanner (System.in)) 
        { // switch --> it is a multiway branch statements
            int opt;
            System.out.print("Enter your option: "); opt = sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("C");
                    break;
                case 2:
                    System.out.println("D");
                    break;
                default:
                    System.out.println("None");
                    break;
            }

            // Looping / Iterating (While, do while, for)
            //while (Entry check):
            System.out.println("While: ");
            int a;
            System.out.print("Enter the Value of A: "); a = sc.nextInt();
            System.out.println(a);

            while (a<=5)
            {
                a+=2;
                System.out.println(a);
            }
            
            //do while
            System.out.println("Do while: ");
            int i=1;
            do
            {
                System.out.println(i);
                i++;
            }while (i<4);
            
            //for
            System.out.println("For: ");
            int d;
            for (d=1;d<=5;d++)
            {
                System.out.println(d);
            }
        }   
    }    
} 
