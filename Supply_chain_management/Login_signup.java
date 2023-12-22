package Supply_chain_management;
import java.sql.*;
import java.util.*;
import java.time.*;

public class Login_signup
{
    public static String username; 
    public static void intro() throws ClassNotFoundException, SQLException
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String optionx;

            System.out.print("\n                      SUPPLY CHAIN MANAGEMENT\n                      [Signup | Login | Quit]\n\nEnter your Option: ");

            optionx = sc.nextLine();

            switch (optionx.toLowerCase())
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

    public static void signup() throws ClassNotFoundException, SQLException
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String user_name, user_username, user_password, user_email, query; boolean exists; long user_mobile;
            
            System.out.print("\nEnter your Name: ");
            user_name=sc.nextLine();

            System.out.print("Enter your Username: ");
            user_username = sc.nextLine();

            exists = check_username(user_username);

            if (exists)
            {
                System.out.println("\nUsername Already exist! Try a new username!");
                System.out.print("\nEnter your Username: ");
                user_username = sc.nextLine();
            }

            while (user_username.startsWith("ADMIN"))
            {
                System.out.println("\nUsername Cannot start with 'ADMIN");
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

            LocalDateTime registeredtime = LocalDateTime.now();

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
                Statement st = con.createStatement();

                query = "INSERT INTO user_info (Name,Username,Password,Email,Mobile,`Registered Date & Time`) VALUES('"+user_name+"','"+user_username+"','"+user_password+"','"+user_email+"','"+user_mobile+"','"+registeredtime+"')";
                
                st.executeUpdate(query);

                System.out.print("\n Data registered Successfully!!\n");
                
                intro();
            }

            catch (Exception e)
            {
                System.out.println("\nAn Error Occured");
            }
        }

        catch (InputMismatchException e)
        {
            System.out.println("Invalid Data!\nUser data not Registered!");
            intro();
        }
    }

    public static boolean check_username(String user_username) throws ClassNotFoundException, SQLException
    {
        String query;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
        Statement st = con.createStatement();

        query = "SELECT * FROM user_info WHERE Username = '"+user_username+"'";
        ResultSet rs = st.executeQuery(query);

        if(rs.next())
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public static void login() throws ClassNotFoundException, SQLException
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String login_password,user_dbpassword,user_dbname,query; int i;

            System.out.println("\n                             LOGIN PAGE\n\nEnter your Details:");

            System.out.print("Username / Employee ID: ");
            username = sc.nextLine();
            
            System.out.print("password: ");
            login_password = sc.nextLine();

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

            ResultSet rs = st.executeQuery(query);

            if (rs.next())
            {
                user_dbpassword = rs.getString(4);
                user_dbname = rs.getString(3);

                for (i=0;i<=1;++i)
                {
                    if (login_password.equals(user_dbpassword))
                    {
                        System.out.println("\nLogin Successfull!!\n                         Welcome "+user_dbname);
            
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
                        login_password = sc.nextLine();                    
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
