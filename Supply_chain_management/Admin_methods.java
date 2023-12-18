package Supply_chain_management;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class Admin_methods extends Login_signup
{
    public static void admin_main_page() throws ClassNotFoundException, SQLException
    {
        try(Scanner sc = new Scanner (System.in))
        {
            String option;

            System.out.println("                         [Admin Profile]");

            System.out.println("\n[Manage My Info | User info | Supply info | Raw materials Warehouse info | Manufacturing Info | Distribution Info | LogOut]");
            
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
                
                case "suppy info":
                {
                    supply_info();
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
        String query,option,option1,updatefield;
        try(Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            query = "SELECT * FROM admin_info WHERE `Admin ID` = '"+username+"'";
            ResultSet rs = st.executeQuery(query);

            rs.next();

            System.out.println("\nAdmin ID: "+rs.getString(2));
            System.out.println("Admin Name: "+rs.getString(3));
            System.out.println("Admin Email: "+rs.getString(5));
            System.out.println("Admin Mobile: "+rs.getString(6));
            System.out.println("Date of Joining: "+rs.getString(7));
            System.out.println("Admin Department: "+rs.getString(8));

            System.out.println("\n[Update info | Exit to main page]");
            System.out.print("\nEnter your option: ");
            option = sc.nextLine();

            String arr1[] = {"update","update info","exit","exit to main page"};
                
            while (!Arrays.asList(arr1).contains(option.toLowerCase()))
            {
                System.out.print("\nOption Not found!\n\nEnter your option: ");
                option = sc.nextLine();
            }

            if (option.toLowerCase().equals("update") || option.toLowerCase().equals("update info"))
            {
                
                System.out.println("\n[Name | Mobile | Email | Password | Department]");
                System.out.print("\nEnter the info to be updated: ");
                option1= sc.nextLine(); 

                updatefield = option1.toLowerCase();
                change_admin(updatefield);
            }

            else if (option.toLowerCase().equals("exit") || option.toLowerCase().equals("exit to main page"))
            {
                admin_main_page();   
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void change_admin(String updatefield)
    {
           
        String query,query1,newpass,update,dbpass,oldinfo = null,change_db = null; int i;

        query = "SELECT `Admin Password`,`Admin Name`,`Admin Mobile`,`Admin Email`,`Admin Department` FROM admin_info WHERE `Admin ID` = '"+username+"'";
        
        try(Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            
            System.out.print("\nEnter the new "+updatefield+": ");
            update = sc.nextLine();

            System.out.print("\nEnter your current password to change "+updatefield+": ");
            newpass = sc.nextLine();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();
            dbpass = rs.getString(1);
            
            for (i=0;i<=1;++i)
            {
                if (newpass.equals(dbpass))
                {
                    if (updatefield.equals("name") || updatefield.equals("admin name"))
                    {
                        change_db = "Name";
                        oldinfo = rs.getString(2);
                    }

                    else if (updatefield.equals("mobile") || updatefield.equals("admin mobile"))
                    {
                        change_db = "Mobile";
                        oldinfo = rs.getString(3);
                    }

                    else if (updatefield.equals("email") || updatefield.equals("e-mail") || updatefield.equals("admin email") || updatefield.equals("admin e-mail"))
                    {
                        change_db = "Email";
                        oldinfo = rs.getString(4);
                    }

                    else if (updatefield.equals("password") || updatefield.equals("admin password")) 
                    {
                        change_db = "Password";
                        oldinfo = newpass;
                    }
                    else if (updatefield.equals("department") || updatefield.equals("admin department")) 
                    {
                        change_db = "Department";
                        oldinfo = rs.getString(5);
                    }

                    if (update.equals(oldinfo))
                    {
                        System.out.println("\n Updating "+change_db+" cannot be the same as existing "+updatefield+"! ");
                        manage_admin_login_info();
                    }

                    else
                    {
                        query1 = "UPDATE admin_info SET `Admin "+change_db+"` = '"+update+"' WHERE `Admin ID` = '"+username+"'";
                        st.executeUpdate(query1); 
                        System.out.println("\n"+updatefield+" Updated Successfully!");
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
                    System.out.print("\nEnter your current password to change "+updatefield+": ");
                    newpass = sc.nextLine();
                }
            }
        }

        catch (Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static void user_info()
    {
        String query,query1,admin_upd_username,admin_newpass,admin_dbpass,user_dbpass; int i;
        try (Scanner sc = new Scanner (System.in))
        {
            System.out.print("\nEnter the username to view: ");
            admin_upd_username = sc.nextLine();

            System.out.print("\nEnter your password to view user info: ");
            admin_newpass = sc.nextLine();

            query = "SELECT `Admin Password` FROM admin_info WHERE `Admin ID` = '"+username+"'";
            query1= "SELECT Password FROM user_info WHERE Username = '"+admin_upd_username+"'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");

            Statement st = con.createStatement();
            ResultSet r = st.executeQuery(query);

            r.next();
            
            admin_dbpass = r.getString(1);
            
            for (i=0;i<=1;i++)
            {
                if (admin_newpass.equals(admin_dbpass))
                {
                    ResultSet r1 = st.executeQuery(query1);

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
            System.out.println("An Error Occured!");
        }
    }
    
    public static void supply_info()
    {
        String option, option1;
        System.out.println("\n[View Supply info | Place Supply Order]");

        try(Scanner sc = new Scanner (System.in))
        {
            System.out.print("\nEnter your option: ");
            option = sc.nextLine();

            if (option.toLowerCase().equals("view supply info") || option.toLowerCase().equals("view"))
            {
                view_supply_info();
            }

            else if (option.toLowerCase().equals("place supply order") || option.toLowerCase().equals("place order"))
            {
                System.out.println("\n[Enter Order Details | Exit]");
                System.out.print("\nEnter your Option: ");
                option1 = sc.nextLine();

                if (option1.toLowerCase().equals("enter order details") || option1.toLowerCase().equals("enter details"))
                {
                    enter_supply_order_details();
                }

                else if (option1.toLowerCase().equals("exit"))
                {
                    supply_info();
                }
            }

            else
            {
                System.out.println("\nInvalid Input!");
                supply_info();
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void view_supply_info()
    {

    }
    
    public static void enter_supply_order_details() throws SQLException, SQLTimeoutException
    {
        String orderitem = "", option, query, query1, arr1[] = {}, shape;
        int number,i, num,materialcost=0, cost=0, totalbill = 0, quantity = 0, height, width, breadth, diameter, radius, volume=0,ratio = 0;

        LocalDateTime ordertime = LocalDateTime.now();
    
        try(Scanner sc = new Scanner (System.in))
        {
            try
            {
                System.out.print("\nEnter the number of items to be ordered: ");
                number = sc.nextInt();
            }

            catch(Exception e)
            {
                System.out.println("Invalid Input!");

                System.out.print("\nEnter the number of items to be ordered: ");
                number = sc.nextInt();    
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            for (i=0;i<number;++i)
            {
                System.out.println("\nType done to proceed to Checkout! ");

                System.out.print("\nEnter the Item to be Ordered: ");
                orderitem = sc.nextLine();

                if (orderitem.toLowerCase().equals(""))
                {
                    orderitem = sc.nextLine();
                }

                if (orderitem.toLowerCase().equals("done"))
                {
                    break;
                }

                boolean exists = check_material(orderitem);

                while (!exists)
                {
                    System.out.println("Item Not Available!");
                    System.out.print("Enter the item to be ordered: ");
                    orderitem = sc.nextLine();
                }

                query = "SELECT * FROM raw_materials_warehouse_info WHERE `Material Name` = '"+orderitem+"'";

                ResultSet rs1 = st.executeQuery(query);

                if (rs1.next())
                {
                    System.out.println("[Rectangular | Cylinder]");
                    shape = sc.nextLine();

                    System.out.println("Number of components in same material ("+orderitem+"): ");
                    num = sc.nextInt();

                    for (i=1;i<num;i++)
                    {
                        System.out.print("Enter Dimensions: ");
                    
                            if (shape.toLowerCase().equals("rectangluar: "))
                        {
                            System.out.print("Height: ");
                            height = sc.nextInt();
                        
                            System.out.print("Breadth: ");
                            breadth = sc.nextInt();

                            System.out.println("Thickness: ");
                            width = sc.nextInt();

                            volume = height*width*breadth;
                        }

                        else if (shape.toLowerCase().equals("cylinder"))
                        {
                            height = sc.nextInt();
                            diameter = sc.nextInt();
                            radius = diameter/2;

                            volume = (22/7)*((radius)*(radius))*(height);
                        }
                    }

                    System.out.println("Cost For 1000 cubic cm: ");
                    materialcost = rs1.getInt(3);

                    ratio = volume/1000000;

                    cost = ratio*materialcost;

                    System.out.print("Enter the Quantity: ");
                    quantity = sc.nextInt();

                    totalbill += cost*quantity;

                    ArrayList <String> additem = new ArrayList<String>(Arrays.asList(arr1));
                
                    additem.add("Item name ("+orderitem+") : Specifications ("+volume+") : Quantity ("+quantity+")");

                    arr1 = additem.toArray(new String [0]);
                }
            }

            System.out.print("\nThe Items in Cart are: ");

            if (arr1.length == 0)
            {
                System.out.print("0\n");
            }

            else
            {
                for (i=0;i<arr1.length;++i)
                {
                    System.out.println((i+1)+") "+arr1[i]+" : "+cost*quantity);
                }
                
                System.out.println("\nThe Total Bill is: "+totalbill);

                System.out.println("\n[Proceed to Checkout | Cancel]");
                System.out.print("\nEnter your option: ");
                option = sc.nextLine();
            
                if (option.toLowerCase().equals("proceed to checkout") || option.toLowerCase().equals("checkout"))
                {
                    System.out.println("Payment will be accepted only after delivery");

                    for (i=0;i<arr1.length;++i)
                    {
                        System.out.println((i+1)+") "+arr1[i]+" : "+cost*quantity);
                        query1 = "INSERT INTO customer_order_info(`Customer Username`,`Order Date`,`Ordered Item`,`Item Specification Details`,`Cost of Order`,`Payment Status`) VALUES('"+username+"','"+ordertime+"','"+arr1[i]+ " ("+quantity+")','"+volume+"','"+cost*quantity+","+"Pending);";
                    }
                    
                    query1 = "INSERT INTO customer_order_info(`Customer Username`,`Order Date`,`Ordered Item`,`Item Specification Details`,`Cost of Order`,`Payment Status`) VALUES('"+username+"','"+ordertime+"','"+orderitem+ " ("+quantity+")','"+volume+"','"+cost*quantity+","+"Pending);";

                    st.executeUpdate(query1);

                    System.out.println("Order made successfully!!");
                }

                else if (option.toLowerCase().equals("cancel"))
                {   
                }
            }
        }

        catch (Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static boolean check_material(String orderitem) throws Exception
    {
        String query;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
        Statement st = con.createStatement();

        query = "SELECT * FROM raw_materials_warehouse_info WHERE `Material Name` = '"+orderitem+"'";
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
