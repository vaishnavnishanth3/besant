package Supply_chain_management;
import java.sql.*;
import java.util.*;

public class Admin_methods extends Login_signup
{
    public static void admin_main_page()
    {
        try(Scanner sc = new Scanner (System.in))
        {
            String option;

            System.out.println("                         [Admin Profile]");

            System.out.println("\n[Manage My Info | User info | Raw Materials Supply info | Raw materials Warehouse info | Manufacturing Info | Distribution Info | LogOut]");
            
            System.out.print("\nEnter Your Option: "); 
            option = sc.nextLine();
            
            switch (option.toLowerCase())
            {
                case "manage my info":
                {
                    manage_admin_login_info();
                    break;
                }

                case "user info":
                {
                    user_info();
                    break;
                }
                
                case "raw materials suppy info":
                {
                    raw_materials_supply_info();
                    break;
                }

                case "raw materials warehouse info":
                {
                    raw_materials_warehouse_info();
                    break;
                }

                case "manufacturing info":
                {
                    manufacturing_info();
                    break;
                }

                case "distribution info":
                {
                    distribution_info();
                    break;
                }

                case "logout":
                {
                    intro();
                }

                default:
                {
                    admin_main_page();
                }
            }
        }
    }

    public static void manage_admin_login_info()
    {
        String query,option1,option2,updatefield1;
        try(Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            query = "SELECT * FROM admin_info WHERE `Admin ID` = '"+username+"'";
            ResultSet rs4 = st.executeQuery(query);

            rs4.next();

            System.out.println("\nAdmin ID: "+rs4.getString(2));
            System.out.println("Admin Name: "+rs4.getString(3));
            System.out.println("Admin Email: "+rs4.getString(5));
            System.out.println("Admin Mobile: "+rs4.getString(6));
            System.out.println("Date of Joining: "+rs4.getString(7));
            System.out.println("Admin Department: "+rs4.getString(8));

            System.out.println("\n[Update info | Exit to main page]");
            System.out.print("\nEnter your option: ");
            option1 = sc.nextLine();

            String arr1[] = {"update","update info","exit","exit to main page"};
                
            while (!Arrays.asList(arr1).contains(option1.toLowerCase()))
            {
                System.out.print("\nOption Not found!\n\nEnter your option: ");
                option1 = sc.nextLine();
            }

            if (option1.toLowerCase().equals("update") || option1.toLowerCase().equals("update info"))
            {
                
                System.out.println("\n[Name | Mobile | Email | Password | Department]");
                System.out.print("\nEnter the info to be updated: ");
                option2= sc.nextLine(); 

                updatefield1 = option2.toLowerCase();
                change_admin(updatefield1);
            }

            else if (option1.toLowerCase().equals("exit") || option1.toLowerCase().equals("exit to main page"))
            {
                admin_main_page();   
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void change_admin(String updatefield1)
    {
           
        String querycheckpass,changequery,newpass,update,dbpass,oldinfo = null,change_db = null; int i;

        querycheckpass = "SELECT `Admin Password`,`Admin Name`,`Admin Mobile`,`Admin Email`,`Admin Department` FROM admin_info WHERE `Admin ID` = '"+username+"'";
        
        try(Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            
            System.out.print("\nEnter the new "+updatefield1+": ");
            update = sc.nextLine();

            System.out.print("\nEnter your current password to change "+updatefield1+": ");
            newpass = sc.nextLine();

            Statement st = con.createStatement();
            ResultSet rs5 = st.executeQuery(querycheckpass);

            rs5.next();
            dbpass = rs5.getString(1);
            
            for (i=0;i<=1;++i)
            {
                if (newpass.equals(dbpass))
                {
                    if (updatefield1.equals("name") || updatefield1.equals("admin name"))
                    {
                        change_db = "Name";
                        oldinfo = rs5.getString(2);
                    }

                    else if (updatefield1.equals("mobile") || updatefield1.equals("admin mobile"))
                    {
                        change_db = "Mobile";
                        oldinfo = rs5.getString(3);
                    }

                    else if (updatefield1.equals("email") || updatefield1.equals("e-mail") || updatefield1.equals("admin email") || updatefield1.equals("admin e-mail"))
                    {
                        change_db = "Email";
                        oldinfo = rs5.getString(4);
                    }

                    else if (updatefield1.equals("password") || updatefield1.equals("admin password")) 
                    {
                        change_db = "Password";
                        oldinfo = newpass;
                    }
                    else if (updatefield1.equals("department") || updatefield1.equals("admin department")) 
                    {
                        change_db = "Department";
                        oldinfo = rs5.getString(5);
                    }

                    if (update.equals(oldinfo))
                    {
                        System.out.println("\n Updating "+change_db+" cannot be the same as existing "+updatefield1+"! ");
                        manage_admin_login_info();
                    }

                    else
                    {
                        changequery = "UPDATE admin_info SET `Admin "+change_db+"` = '"+update+"' WHERE `Admin ID` = '"+username+"'";
                        st.executeUpdate(changequery); 
                        System.out.println("\n"+updatefield1+" Updated Successfully!");
                        manage_admin_login_info();
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
                    System.out.print("\nEnter your current password to change "+updatefield1+": ");
                    newpass = sc.nextLine();
                }
            }
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void user_info()
    {
        String querycheckpass1,querycheckpass2,admin_upd_username,admin_newpass,admin_dbpass,user_dbpass; int i;
        try (Scanner sc = new Scanner (System.in))
        {
            System.out.print("\nEnter the username to view: ");
            admin_upd_username = sc.nextLine();

            System.out.print("\nEnter your password to view user info: ");
            admin_newpass = sc.nextLine();

            querycheckpass1 = "SELECT `Admin Password` FROM admin_info WHERE `Admin ID` = '"+username+"'";
            querycheckpass2 = "SELECT Password FROM user_info WHERE Username = '"+admin_upd_username+"'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");

            Statement st = con.createStatement();
            ResultSet r = st.executeQuery(querycheckpass1);

            r.next();
            
            admin_dbpass = r.getString(1);
            
            for (i=0;i<=1;i++)
            {
                if (admin_newpass.equals(admin_dbpass))
                {
                    ResultSet r1 = st.executeQuery(querycheckpass2);

                    if (r1.next())
                    {
                        user_dbpass = r1.getString(1);
                        User_methods.manage_my_info(username = admin_upd_username,user_dbpass);
                    }

                    else
                    {
                        System.out.println("User not found! ");
                        user_info();
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
                    System.out.println("Incorrect password! Try again!!");
                }
            }
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void raw_materials_supply_info()
    {

    }

    public static void raw_materials_warehouse_info()
    {
        
    }

    public static void distribution_info()
    {

    }

    public static void manufacturing_info()
    {

    }
}
