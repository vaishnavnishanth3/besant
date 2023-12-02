import java.util.Scanner;
public class assignment4 {
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            int i, s, e, n;
            System.out.print("Enter the number to be table for multiplication: "); n = sc.nextInt();
            System.out.print("Enter the Start value: "); s = sc.nextInt();
            System.out.print("Enter the End value: "); e = sc.nextInt();
            for(i=s;i<=e;i++)
            {
                System.out.println(n*i);
            }
        }
    }
} 