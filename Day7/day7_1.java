// Day 7
import java.util.Scanner;
public class day7_1 
{
    public static void main (String [] args)
    {
        try (Scanner sc = new Scanner (System.in))
        { // bitwise AND, OR, EX-OR
            int a, b, c;
            System.out.print("Enter a value: "); a = sc.nextInt();
            System.out.print("Enter the b value: "); b = sc.nextInt();
            System.out.println("AND: "+ (a&b));
            System.out.println("OR: "+ (a|b));
            System.out.println("EX-OR: "+ (a^b));
        // shift operator (Left, right)
            System.out.print("Enter the Shift value: "); c = sc.nextInt();
            System.out.println("Left Shift: "+ (a<<c));
            System.out.println("Right Shift: "+ (a>>c));
        /* conditions:
        if, if else, else if, nested if, switch */
            Float price;
            System.out.print("Enter the price value: "); price = sc.nextFloat();
            if (price>=500)
            {
                if (price == 500)
                {
                    System.out.println("The price is exactly 500");
                }
                else
                {
                    System.out.println("The total Price is "+price);
                }
            }
            else if (price<500) // else if ~ elif
            {
                System.out.println("The price is less that 500!!");  
            }
            else 
            {
                System.out.println("Invalid Input!");
            }
        }
    }
}
