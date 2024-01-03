import java.util.Scanner;
public class assignment3 {
    public static void main (String [] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            int i, s, e;
            System.out.print("Enter the Start value: "); s = sc.nextInt();
            System.out.print("Enter the End Value: "); e = sc.nextInt();
            for (i=s;i<=e;++i)
            {
                if (i%2==0)
                {
                    System.out.println(i);
                }
            }
        }
    }
}
