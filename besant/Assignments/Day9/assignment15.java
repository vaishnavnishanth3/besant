import java.util.Scanner;
public class assignment1 
{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner (System.in))    
        {   int s, e; float sum=0, i, avg;
            System.out.print("Enter the Start value: "); s = sc.nextInt();
            System.out.print("Enter the End Value: "); e = sc.nextInt();
            for (i=s;i<=e;++i)
            {
                sum+=i;
            }
            avg = (float)sum/e;
            System.out.println("The sum of 1 to 10 is "+sum+" & the average is "+avg);
        }
    }
}
