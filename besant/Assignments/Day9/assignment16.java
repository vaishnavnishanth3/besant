import java.util.Scanner;
public class assignment2 {
    public static void main (String[] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            int i, s, e, sq=0, cu=0;
            System.out.print("Enter the Start Value: "); s = sc.nextInt();
            System.out.print("Enter the End Value: "); e = sc.nextInt();

            for(i=s;i<=e;++i)
            {
                sq = i*i;
                System.out.println("\nThe square of "+i+" is "+sq);
                cu = i*i*i;
                System.out.println("The cube of "+i+" is "+cu+"\n");
            }
        }
    }   
}