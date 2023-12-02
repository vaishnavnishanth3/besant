import java.util.Scanner;
public class assignment7 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in))
        {
            int a,b,c;
            System.out.print("Enter the first number: "); a = sc.nextInt();
            System.out.print("Enter the second number: "); b = sc.nextInt();
            System.out.print("Enter the third number: "); c = sc.nextInt();
            if (a>b)
            {
                if (a>c)
                {
                    System.out.println(a+" is the largest number!");
                }
                else if (c>a)
                {
                    System.out.println(c+" is the largest number!");
                }
            }
            else if (b>a) 
            {  
                if (b>c)
                {
                    System.out.println(b+" is the largest number");
                }
                else if (c>b)
                {
                    System.out.println(c+" is the largest number");
                }
            }
        }
    }    
}
