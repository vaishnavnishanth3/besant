import java.util.Scanner;
public class assignment23 {
    public static void main (String [] args) {
        try(Scanner sc = new Scanner (System.in))
        {
            int i, j=0, n, x[];
            System.out.print("Enter the number of elements in array: "); n =sc.nextInt();
            x=new int [n];
            for (i=0;i<=(n-1);++i)
            {
                System.out.print("Enter the element "+(i+1)+": "); x[i] = sc.nextInt();
            }
            System.out.print("The entered array is: ");
            for (i=0;i<=(n-1); ++i)
            {
                if (i==(n-1))
                {
                    System.out.println(x[i]);
                }
                else
                {
                    System.out.print(x[i]+", ");
                }
            }
            System.out.print("The Largest Element is: ");
            for (i=0;i<=(n-1);++i)
            {
                if (x[i]>=x[j])
                {
                    j=i;
                }    
                else if (x[i]<x[j])
                {
                    j+=0;
                } 
            }
            System.out.print(x[j]);
        }
    }
}
