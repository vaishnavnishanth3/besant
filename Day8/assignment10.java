import java.util.Scanner;
public class assignment10 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner (System.in))
        {   
            int age;
            System.out.print("Enter your age: "); age = sc.nextInt();
        
            if (age<0)
            {
                System.out.println("Invalid Input");
            }

            else if (age>=0)
            {
                if (age>=18)
                {
                    System.out.println("You're Eligiblr for voting!");
                }
        
                else
                {
                    System.out.println("You're not eligible for voting!");
                }
            }
        }
    }
}