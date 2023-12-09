package Supply_chain_management;
import java.sql.*;
import java.util.*;

public class User_methods extends Login_signup
{
    public static String updatefield,newpass;
    public static void user_main_page() throws ClassNotFoundException, SQLException
    {
        try(Scanner sc = new Scanner (System.in))
        {
            String option2;

            System.out.println("                          [User Profile]");

            System.out.println("\n [Manage My Info | Place Order | View Order Details | Communicate | LogOut]");
            
            System.out.print("\nEnter your Option: "); 
            option2 = sc.nextLine();

            switch (option2.toLowerCase())
            {
                case "manage my info":
                {
                    newpass = "";
                    manage_my_info(username,newpass);
                    break;
                }

                case "place order":
                {
                    place_order();
                    break;
                }

                case "view order details":
                {
                    view_order_details();
                    break; 
                }

                case "communicate":
                {
                    communicate();
                    break; 
                } 

                case "logout":
                {
                    intro();
                    break;
                }

                default:
                {
                    System.out.println("Invalid Input!");
                    user_main_page();
                }
            }            
        }
    }

    public static void manage_my_info(String username, String newpass)
    {   
        String query3;
        
        try (Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();
            
            query3 = "SELECT * FROM user_info WHERE Username = '"+username+"'";

            ResultSet rs3 = st.executeQuery(query3);
            
            rs3.next();
            
            System.out.println("\nUserID: "+rs3.getString(1));
            System.out.println("Username: "+rs3.getString(2));
            System.out.println("Name: "+rs3.getString(3));
            System.out.println("Mobile: "+rs3.getString(5));
            System.out.println("Email: "+rs3.getString(6));

            update_info(username,newpass);

        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void update_info(String username, String newpass)
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String option3,option4,updatefield;
            System.out.println("\n[Update info | Exit to main page]");
            System.out.print("\nEnter your option: ");
            option3 = sc.nextLine();

            String arr1[] = {"update","update info","exit","exit to main page"};
                
            while (!Arrays.asList(arr1).contains(option3.toLowerCase()))
            {
                System.out.print("\nOption Not found!\n\nEnter your option: ");
                option3 = sc.nextLine();
            }

            if (option3.toLowerCase().equals("update info") || option3.toLowerCase().equals("update"))
            {
                System.out.println("\n[Name | Mobile | Email | Password]");
                System.out.print("\nEnter the info to be updated: ");
                option4= sc.nextLine();
            
                updatefield = option4.toLowerCase();

                while (updatefield.equals("username") || updatefield.toLowerCase().equals("userid"))
                {
                    System.out.println("Username or UserID cannot be changed!");
                    option4 = sc.nextLine();
                }

                String arr2[] = {"name","mobile","email","password","username","userid"};

                while (!Arrays.asList(arr2).contains(updatefield))
                { 
                    System.out.print("\nField not found!\nEnter the info to be updated: ");
                    option4= sc.nextLine();
                }

                change(updatefield,newpass);
            }

            else if (option3.toLowerCase().equals("exit to main page") || option3.toLowerCase().equals("exit"))
            {
                user_main_page();
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void change(String updatefield, String newpass)
    {   
        String query4,query5,update,dbpass,oldinfo = null,change_db = null; int i;

        query4 = "SELECT Password,Name,Mobile,Email FROM user_info WHERE Username = '"+username+"'";
        
        try(Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            
            System.out.print("\nEnter the new "+updatefield+": ");
            update = sc.nextLine();
            
            Statement st = con.createStatement();
            ResultSet rs4 = st.executeQuery(query4);

            rs4.next();
            dbpass = rs4.getString(1);

            if (newpass.equals(""))
            {
                System.out.print("\nEnter user password to change "+updatefield+": ");
                newpass = sc.nextLine();
            }

            for (i=0;i<=1;++i)
            {
                if (newpass.equals(dbpass))
                {
                    if (updatefield.equals("name"))
                    {
                        change_db = "Name";
                        oldinfo = rs4.getString(2);
                    }

                    else if (updatefield.equals("mobile"))
                    {
                        change_db = "Mobile";
                        oldinfo = rs4.getString(3);
                    }

                    else if (updatefield.equals("email") || updatefield.equals("e-mail"))
                    {
                        change_db = "Email";
                        oldinfo = rs4.getString(4);
                    }

                    else if (updatefield.equals("password"))
                    {
                        change_db = "Password";
                        oldinfo = newpass;
                    }

                    if (update.equals(oldinfo))
                    {
                        System.out.println("\n Updating "+change_db+" cannot be the same as existing "+updatefield+"! ");
                        manage_my_info(username,dbpass);
                    }

                    else
                    {
                        query5 = "UPDATE user_info SET "+change_db+" = '"+update+"' WHERE Username = '"+username+"'";
                        st.executeUpdate(query5); 
                        System.out.println("\n"+updatefield+" Updated Successfully!");
                        manage_my_info(username,dbpass);
                    }
                    
                    break;
                }

                else if (i==1)
                {
                    System.out.println("Max limit reached (Wrong password!)\nYou are logged out!");
                    intro();
                }

                else                    
                {
                    System.out.println("\nIncorrect Password! Try Again!");
                    System.out.print("\nEnter your current password to change "+updatefield+": ");
                    newpass = sc.nextLine();
                }
            }
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void place_order()
    {

    }

    public static void view_order_details()
    {

    }

    public static void communicate()
    {
        
    }
}
