import java.util.Scanner;
public class assignment5 {
    public static void main(String [] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {   
            int i, s, e, sum=0;
            System.out.print("Enter the Start Value: "); s = sc.nextInt();
            System.out.print("Enter the End Value: "); e = sc.nextInt();
            for (i=s;i<=e;++i)
            {
                if (i%2 != 0)
                {
                    System.out.println(i);
                    sum += i; 
                }
            }
            System.out.println("The sum of odd numbers is "+sum);
        }
    }
}
