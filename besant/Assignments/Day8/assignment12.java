import java.util.Scanner;
public class assignment12 
{
    public static void main(String[] args) 
    {
        try(Scanner sc = new Scanner (System.in)) 
        {
            int num;
            System.out.print("Enter your number: "); num = sc.nextInt();
            if (num%5 == 0)
            {
                System.out.println("The number is divisible by 5! ");
            }
            else
            {
                System.out.println("The number is not divisible by 5! ");
            }
        }
    }    
}
