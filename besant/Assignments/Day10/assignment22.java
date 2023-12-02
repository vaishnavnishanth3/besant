import java.util.Scanner;
public class assignment22 {
    public static void main (String[] args)
    {
        try(Scanner sc = new Scanner (System.in))
        {
            int i, j, n, x[];
            System.out.print("Enter the number of elements you want in array: "); n = sc.nextInt();
            x = new int [n];
            
            for (i=0;i<=(n-1);++i)
            {
                System.out.print("Enter the element "+(i+1)+": "); x[i] = sc.nextInt();
            }
            System.out.print("The Array: ");
            for (i=0;i<=(n-1);++i)
            {
                if (i==(n-1))
                System.out.println(x[i]);
                else
                System.out.print(x[i]+", ");
            }
            System.out.print("The Reversed Array: ");
            for (i=0;i<=(n-1);++i)
            {
                j=(n-1)-i;
                if (j<=(n/2))
                {
                    x[i]=x[j];
                }
                else
                {
                    x[i]=x[i];
                }
                if (i==(n-1))
                {
                    System.out.print(x[j]);
                }
                else
                {
                    System.out.print(x[j]+", ");

                }
            }

        }
    }
}
