import java.util.Scanner;
public class assignment20 {
    public static void main(String[] args) {
        try(Scanner sc= new Scanner (System.in))
        {
            int i, n, x[],sum=0;
            System.out.print("Enter the number of subjects: "); n = sc.nextInt();
            x = new int[n];
            for (i=0;i<=n-1;++i)
            {
                System.out.print("Enter the score for subject "+(i+1)+": "); x[i] = sc.nextInt();
            }
            System.out.print("The Scores are: ");
            for(i=0;i<=n-1;++i)
            {   
                sum+=x[i];
                if (i==(n-1))
                System.out.println(x[i]);
                else
                System.out.print(x[i]+", ");
            }
            System.out.println("The total sum is: "+sum);
        }
    }
}
