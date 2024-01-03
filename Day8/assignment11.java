import java.util.Scanner;
public class assignment11 {
    public static void main (String [] args) 
    {
        try(Scanner sc = new Scanner (System.in))
        {
            int num1, num2;
            System.out.print("Enter your number 1: "); num1 = sc.nextInt();
            System.out.print("Enter your number 2: "); num2 = sc.nextInt();
            if (num1 == num2)
            {
                System.out.println("The numbers are equal!");
            }
            else 
            {
                System.out.println("The numbers are NOT equal!");
            }
        }
    }
}
