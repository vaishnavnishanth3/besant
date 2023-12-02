import java.util.Scanner;
public class assignment25 {
    public static void main(String[] args) {
        try(Scanner sc= new Scanner (System.in) )
        {
            int i, j, r, c, mat_A[][], Transpose_A[][];
            System.out.print("\nEnter the number of rows: "); r = sc.nextInt();
            System.out.print("Enter the number of coloumns: "); c = sc.nextInt();
            mat_A = new int[r][c];
            Transpose_A = new int[r][c];

            System.out.println("\nFor Matrix A:");
            for(i=0;i<=r-1;++i)
            {
                for(j=0;j<=c-1;++j)
                {
                    System.out.print("Enter the element a"+(i+1)+""+(j+1)+": "); mat_A[i][j]= sc.nextInt();
                }
            }
            System.out.println("\nMatrix A:");
            for(i=0;i<=r-1;++i)
            {
                for(j=0;j<=c-1;++j)
                {
                    System.out.print(mat_A[i][j]+" ");
                }
                System.out.println();
            }
            for(i=0;i<=r-1;++i)
            {
                for(j=0;j<=c-1;++j)
                {   
                    if (i==j)
                    {
                        Transpose_A[i][j] = mat_A[i][j];
                    }
                    else
                    {
                        Transpose_A[i][j] = mat_A[j][i];
                    }
                }
            }
            System.out.println("\nTranspose of A:");
            for(i=0;i<=r-1;++i)
            {
                for(j=0;j<=c-1;++j)
                {
                    System.out.print(Transpose_A[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
