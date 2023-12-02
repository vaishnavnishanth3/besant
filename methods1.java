package Java.Project1;
import java.util.*;
public class methods1 
{
    Scanner sc = new Scanner (System.in);
    
    public static void intro()
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String option1;
            System.out.println("\n                      SUPPLY CHAIN MANAGEMENT\n"+"                         [Login | Signup]");
            System.out.print("\nEnter your Option: ");

            option1 = sc.nextLine().toLowerCase();

            if (option1.toLowerCase().equals("login"))
            {
                login();
            }
            else if (option1.toLowerCase().equals("signup"))
            {
                signup();
            }
            else
            {
                System.out.println("Invalid option");
                intro();
            }
        }
    }

    public static void login()
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String username,password;
            System.out.println("\n                          LOGIN PAGE\n\nEnter your Details:");
            System.out.print("Username / Employee ID: ");
            username = sc.nextLine().toLowerCase();
            
            System.out.print("password: ");
            password = sc.nextLine().toLowerCase();

        }
    }

    public static void signup() 
    {
    
    }
}
