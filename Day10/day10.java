//day10 Arrays
import java.util.Scanner;
public class day10
{
    public static void main (String [] args) 
    {
        try(Scanner sc = new Scanner(System.in))
        {
            int i, j, n, a[]= {100,200,300,400,500};
            
            for (i=0;i<=5-1;++i)
            {
                System.out.println(a[i]);
            }

            System.out.print("Enter the number of elements to append: "); n = sc.nextInt();
            
            int x[] = new int[n];
            
            for (i=0;i<=n-1;++i)
            {
                System.out.print("Enter the element "+(i+1)+": "); x[i] = sc.nextInt(); 
            }
            
            System.out.print("The Elements in Arraylist are: ");
            
            for (i=0;i<=n-1;++i)
            {
                if (i==(n-1))
                System.out.println(x[i]);
                else
                System.out.print(x[i]+", ");
            }
            int arr[][] = 
                        {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                        };
            for (i=0;i<3;i++)
            {
                for (j=0;j<3;j++)
                {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        } 
    } 
} 
