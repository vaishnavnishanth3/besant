import java.util.Scanner;
public class assignment21 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in))
        {
            int i, n, sumeven=0, sumodd=0, x[];
            System.out.print("Enter the number of elements in array: "); n = sc.nextInt();
            x = new int[n];
            for (i=0; i<=(n-1); i++)
            {
                System.out.print("Enter the element "+(i+1)+": "); x[i] = sc.nextInt();
            }
            
            for (i=0; i<=(n-1); i++)
            {   
                if (i==(n-1))
                System.out.println(x[i]);
                else
                System.out.print(x[i]+", ");
            }

            for (i=0;i<=n; i+=2)
            {
                sumeven += i;
            }
            System.out.println("Sum of elements of even index are: "+sumeven);
            
            for (i=1;i<=n; i+=2)
            {
                sumodd += i;
            }
            System.out.println("Sum of elements of odd index are: "+sumodd);
        }
    }
}
