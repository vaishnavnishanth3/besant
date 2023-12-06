package Supply_chain_management;
import java.sql.*;
import java.util.*;

public class Login_signup
{
    public static String username; 
    public static void intro()
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String option;

            System.out.print("\n                      SUPPLY CHAIN MANAGEMENT\n                      [Signup | Login | Quit]\n\nEnter your Option: ");

            option = sc.nextLine();

            switch (option.toLowerCase())
            {
                case "signup":
                {
                    signup();
                    break;
                }

                case "login":
                {
                    login();
                    break;
                }
             
                case "quit":
                {    
                    break;
                }

                default: 
                {   
                    System.out.println("\nInvalid Input!");
                    intro();
                }
            }
        }
    }

    public static void signup() 
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String user_name, user_username, user_password, user_email, query; long user_mobile;
            
            System.out.print("\nEnter your Name: "); 
            user_name=sc.nextLine();

            System.out.print("Enter your Username: "); 
            user_username = sc.nextLine();

            while (user_username.startsWith("ADMIN"))
            {
                user_username = sc.nextLine();
            }
            
            System.out.print("Enter your Password: "); 
            user_password = sc.nextLine();
            
            System.out.print("Enter your Email: ");
            user_email = sc.nextLine();

            while (!user_email.endsWith(".com"))
            {
                System.out.print("\nInvalid Email!\nEnter your Email: ");
                user_email = sc.nextLine();
            }

            System.out.print("Enter your Mobile: ");
            user_mobile = sc.nextLong();

            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
                Statement st = con.createStatement();

                query = "INSERT INTO user_info (Name,Username,Password,Email,Mobile) VALUES('"+user_name+"','"+user_username+"','"+user_password+"','"+user_email+"','"+user_mobile+"');";
                
                int rs = st.executeUpdate(query);
                System.out.print("\n"+rs+ " Data registered Successfully!!\n");
                intro();
            }

            catch (Exception e)
            {
                System.out.println("\n"+e);
            }
        }

        catch (InputMismatchException e)
        {
            System.out.println("Invalid Data!\nUser data not Registered!");
            intro();
        }
    }

    public static void login()
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String password,dbpassword,dbname; int i;

            System.out.println("\n                             LOGIN PAGE\n\nEnter your Details:");

            System.out.print("Username: ");
            username = sc.nextLine();
            
            System.out.print("password: ");
            password = sc.nextLine();

            String query;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            if (username.startsWith("ADMIN"))
            {
                query = "SELECT * FROM admin_info WHERE `Admin ID` = '"+username+"'";
            }

            else
            {
                query = "SELECT * FROM user_info WHERE `Username` = '"+username+"'";
            }

            ResultSet rs1 = st.executeQuery(query);

            if (rs1.next())
            {
                dbpassword = rs1.getString(4);
                dbname = rs1.getString(3);

                for (i=0;i<=1;++i)
                {
                    if (password.equals(dbpassword))
                    {
                        System.out.println("\nLogin Successfull!!\n                         Welcome "+dbname);
            
                        if (username.startsWith("ADMIN"))
                        {
                            Admin_methods.admin_main_page();
                            break;
                        }
                    
                        else
                        {
                            User_methods.user_main_page();
                            break;
                        }                       
                    }

                    else if (i==1)
                    {
                        System.out.println("\nMax limit reached, Try after sometimes.");
                        intro();
                    }

                    else
                    {  
                        System.out.println("\nIncorrect Password!");
                        System.out.print("password: ");
                        password = sc.nextLine();                    
                    }
                }
            }
        
            else
            {
                System.out.println("\nUser Not found, make sure to register/signup before logging in");
                intro();
            }
        }

        catch (Exception e)
        {
            System.out.println("\nAn Error Occured!");
            intro();
        }
    }
}
