import java.util.Scanner;
public class assignment14 {
    public static void main (String [] args) 
    {
        try(Scanner sc = new Scanner (System.in))
        {
            int a, b;
            System.out.print("Enter the First number: "); a = sc.nextInt();
            System.out.print("Enter the Second number: "); b = sc. nextInt();
            if (a>b)
            {
                System.out.println(b+ " is the smallest number");
            }
            else
            {
                System.out.println(a+ " is the smallest number");
            }

        }
    }
}
