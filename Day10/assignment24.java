import java.util.Scanner;
public class assignment24 
{
    public static void main(String[] args) 
    {
        try(Scanner sc = new Scanner (System.in))
        {   
            int i, j, r, c, mat_A[][], mat_B[][], mat_A_plus_B[][];
            
            //matrix 1
            System.out.print("\nEnter the number of rows: "); r = sc.nextInt();
            System.out.print("Enter the number of columns:"); c = sc.nextInt();
            mat_A = new int [r][c]; 
            System.out.println("\nFor Matrix A: ");
            for (i=0;i<r;++i)
            {
                for (j=0;j<c;++j)
                {
                    System.out.print("Enter the element for a"+(i+1)+""+(j+1)+": "); mat_A[i][j] = sc.nextInt();
                }
            }
            System.out.println("\nMatrix A: ");
            for (i=0;i<r;++i)
            {
                for (j=0;j<c;++j)
                {
                    System.out.print(mat_A[i][j]);
                    if (j<c-1)
                    System.out.print(" ");
                }
                System.out.println();
            }

            //matrix 2
            mat_B = new int [r][c];
            System.out.println("\nFor Matrix B: ");
            for (i=0;i<r;++i)
            {
                for (j=0;j<c;++j)
                {
                    System.out.print("Enter the element for b"+(i+1)+""+(j+1)+": "); mat_B[i][j] = sc.nextInt();
                }
            }
            
            System.out.println("\nMatrix B: ");
            for (i=0;i<r;++i)
            {
                for (j=0;j<c;++j)
                {
                    System.out.print(mat_B[i][j]);
                    if (j<c-1)
                    System.out.print(" ");
                }
                System.out.println();
            }

            //adding 2 matrix
            mat_A_plus_B = new int [r][c];
            for (i=0;i<=r-1;++i)
            {
                for (j=0;j<=c-1;++j)
                {
                    mat_A_plus_B[i][j]=mat_A[i][j]+mat_B[i][j];
                }
            }
            System.out.println("\nMatrix [A+B]: ");
            for(i=0;i<=r-1;++i)
            {
                for(j=0;j<=c-1;++j)
                {
                    System.out.print(mat_A_plus_B[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }    
}
