package Supply_chain_management;
import java.sql.*;
import java.util.*;
import java.time.*;

public class User_methods extends Login_signup
{
    public static int arrz[] = {};
    public static String updatefield,newpass;
    
    public static void user_main_page() throws ClassNotFoundException, SQLException
    {
        try(Scanner sc = new Scanner (System.in))
        {
            String option;

            System.out.println("                         [User Profile]");

            System.out.println("\n [Manage My Info | Manage Orders | Communicate | LogOut]");
            
            System.out.print("\nEnter your Option: "); 
            option = sc.nextLine();

            switch (option.toLowerCase())
            {
                case "manage my info":
                {
                    newpass = "";
                    manage_my_info(username,newpass);
                    break;
                }

               case "manage orders":
                {
                    manage_orders();
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
        String query;
        
        try (Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();
            
            query = "SELECT * FROM user_info WHERE Username = '"+username+"'";

            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            System.out.println("\nUserID: "+rs.getString(1));
            System.out.println("Username: "+rs.getString(2));
            System.out.println("Name: "+rs.getString(3));
            System.out.println("Mobile: "+rs.getString(5));
            System.out.println("Email: "+rs.getString(6));

            update_info(username,newpass);
        }

        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static void update_info(String username, String newpass)
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String option,option1,updatefield;

            System.out.println("\n[Update info | Exit to main page]");

            System.out.print("\nEnter your option: ");
            option = sc.nextLine();

            String arr[] = {"update","update info","exit","exit to main page"};
                
            while (!Arrays.asList(arr).contains(option.toLowerCase()))
            {
                System.out.print("\nOption Not found!\n\nEnter your option: ");
                option = sc.nextLine();
            }

            if (option.toLowerCase().equals("update info") || option.toLowerCase().equals("update"))
            {
                System.out.println("\n[Name | Mobile | Email | Password]");
                System.out.print("\nEnter the info to be updated: ");
                option1= sc.nextLine();
            
                updatefield = option1.toLowerCase();

                while (updatefield.equals("username") || updatefield.toLowerCase().equals("userid"))
                {
                    System.out.println("Username or UserID cannot be changed!");
                    option1 = sc.nextLine();
                }

                String arr1[] = {"name","mobile","email","password","username","userid"};

                while (!Arrays.asList(arr1).contains(updatefield))
                { 
                    System.out.println("\nField not found!");
                    System.out.print("\nEnter the info to be updated: ");
                    option1= sc.nextLine();
                }

                change(updatefield,newpass);
            }

            else if (option.toLowerCase().equals("exit to main page") || option.toLowerCase().equals("exit"))
            {
                user_main_page();
            }
        }

        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static void change(String updatefield, String newpass)
    {   
        String query,query1,update,dbpass,oldinfo = null,change_db = null; int i;

        query = "SELECT Password,Name,Mobile,Email FROM user_info WHERE Username = '"+username+"'";
        
        try(Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            
            System.out.print("\nEnter the new "+updatefield+": ");
            update = sc.nextLine();
            
            Statement st = con.createStatement();
            ResultSet rs4 = st.executeQuery(query);

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
                        query1 = "UPDATE user_info SET "+change_db+" = '"+update+"' WHERE Username = '"+username+"'";
                        st.executeUpdate(query1); 
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
            System.out.println("An Error Occured !");
        }
    }

    public static void manage_orders() throws ClassNotFoundException, SQLException
    {
        try (Scanner sc = new Scanner (System.in))
        {
            String option;
            System.out.println("\n[Place Orders | View Orders | Exit]");
            System.out.print("\nEnter your Option: ");
            option = sc.nextLine();
            
            switch(option.toLowerCase())
            {
                case "place orders":
                {
                    place_orders();
                    break;
                }

                case "view orders":
                {
                    view_orders();
                    break;
                }

                case "exit":
                {
                    user_main_page();
                    break;
                }

                default:
                {
                    System.out.println("\nInvalid Input!");
                    manage_orders();
                }
            }
        }
    }

    public static void place_orders() throws ClassNotFoundException, SQLException
    {
        String option;

        try(Scanner sc = new Scanner (System.in))
        {
            System.out.println("\n[Enter Order Details | Exit to Manage Orders]");

            System.out.print("\nEnter your Option: ");
            option = sc.nextLine();

            String arr[] = {"enter order details","enter details","exit","exit to manage orders"};
                
            while (!Arrays.asList(arr).contains(option.toLowerCase()))
            {
                System.out.print("\nOption Not found!\n\nEnter your option: ");
                option = sc.nextLine();
            }

            if (option.toLowerCase().equals("enter order details") || option.toLowerCase().equals("enter details"))
            {
                enter_order_details();
            }

            else if (option.toLowerCase().equals("exit") || option.toLowerCase().equals("exit to manage orders"))
            {
                manage_orders();
            }

            else
            {
                System.out.println("Invalid Input!");
                place_orders();
            }
        }
        
        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static void enter_order_details()
    {
        String query, query1, query2, orderitem, productid, productname;
        int quantity, cost, totalcost;

        try (Scanner sc = new Scanner(System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            query = "SELECT `Product Name` FROM product_info";

            ResultSet rs = st.executeQuery(query);

            System.out.println("\nAvailable Products:");

            while (rs.next())
            {
                System.out.print("\n"+rs.getString("Product Name"));
            }

            System.out.print("\n\nEnter your Component Name: ");
            orderitem = sc.nextLine();

            query1 = "SELECT * FROM product_info where `Product Name` = '"+orderitem+"'";

            ResultSet rs1 = st.executeQuery(query1);

            if (rs1.next())
            {
                System.out.println("\nProduct information \n");
            
                System.out.println("Product ID: "+rs1.getString(1));
                System.out.println("Product Name: "+rs1.getString(2));
                System.out.println("Cost of Each Product: Rs. "+rs1.getString(4)+"/-");
                System.out.println("Precision Rate: "+rs1.getString(7)+" %");
                
                productid = rs1.getString(1);
                productname = rs1.getString(2);
                cost = rs1.getInt(4);

                System.out.print("\nEnter Quantity: ");
                quantity = sc.nextInt();
                            
                totalcost = cost*quantity;

                System.out.println("\nTotal Bill: "+totalcost);

                LocalDateTime ordertime = LocalDateTime.now();

                query2 =  "INSERT INTO customer_order_info (`Customer Username`,`Order Date`,`Product ID`,Quantity,`Cost of Order`,`Payment Status`) Values ('"+username+"','"+ordertime+"','"+productid+"','"+quantity+"','"+totalcost+"','Pending');";
                
                st.executeUpdate(query2);

                String query3 = "SELECT * FROM customer_order_info WHERE `Customer Username` = '"+username+"';";

                rs1 = st.executeQuery(query3);

                while(rs1.next())
                {
                    System.out.println("\nOrder ID: "+rs1.getInt(1));
                    System.out.println("Order Date: "+rs1.getString(3));
                    System.out.println("Product ID: "+rs1.getString(4));
                    System.out.println("Quantity: "+rs1.getInt(5));
                    System.out.println("Cost: "+rs1.getInt(6)+"\n");
                }

                System.out.print("\nEnter the Order ID: ");
                int orderid = sc.nextInt();

                Admin_methods.add_manu_info_to_database(productid,username,productname,"Batch",ordertime,ordertime.plusDays(2),"Order Recieved","null",totalcost,quantity);

                Admin_methods.add_dist_info_to_database(orderid,username,productid,ordertime,ordertime.plusDays(2),cost);

                System.out.println("\nOrder Recieved Successfully!\nPayment Details will be shared during the time of product delivery!");
                
                manage_orders();
            }

            else
            {
                System.out.println("Product not available!");
                enter_order_details();
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void view_orders()
    {
        String query, option;
        int orderid;
        boolean exists;

        try(Scanner sc = new Scanner (System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            query = "SELECT * FROM customer_order_info WHERE `Customer Username` = '"+username+"';";

            ResultSet rs = st.executeQuery(query);

            System.out.println("\nYour orders!\n");

            exists = check_available_orders();

            if(exists)
            {
                while(rs.next())
                {
                    orderid = rs.getInt(1);

                    System.out.print("Order ID: "+orderid);

                    arrz = Arrays.copyOf(arrz,arrz.length+1); 
                    arrz[arrz.length-1] = orderid;

                    System.out.print("\nOrder Date: "+rs.getString(3));
                    System.out.print("\nProduct ID: "+rs.getString(4));
                    System.out.print("\nQuantity: "+rs.getInt(5));
                    System.out.print("\nTotal Cost: "+rs.getInt(6));
                    System.out.print("\nPayment Status: "+rs.getString(7)+"\n\n");
                }
            
                System.out.println("\n[Cancel Orders | Exit]");

                System.out.print("\nEnter your option: ");
                option = sc.nextLine();
            
                if (option.toLowerCase().equals("cancel orders") || option.toLowerCase().equals("cancel"))
                {
                    cancel_orders();
                }

                else if (option.toLowerCase().equals("exit"))
                {
                    manage_orders();
                }
            }
            
            else
            {
                System.out.println("No Orders Active!\nPlease Place order before viewing!!");
                manage_orders();
            }
        }

        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static void cancel_orders()
    {
        System.out.println("\nView Orders before cancelling them!");

        boolean exists;
        String query;
        int  cancelorderid;
        
        try(Scanner sc = new Scanner(System.in))
        {
            System.out.print("\nEnter the Order ID to cancel the order: ");
            cancelorderid = sc.nextInt();

            exists = check_orders(cancelorderid);
            
            if (exists)
            {
                System.out.println("Order Cancelled! ");

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
                Statement st = con.createStatement();

                query = "DELETE FROM customer_order_info WHERE `Order ID` = '"+cancelorderid+"';";

                st.executeUpdate(query);
            }

            else
            {
                System.out.println("\nNo Active orders with Order ID: "+cancelorderid+"\nNo Orders Cancelled!");
            }

            manage_orders();        
        }

        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static boolean check_orders(int cancelorderid)
    {
        try
        {
            for (int i : arrz)
            {
                if (i == cancelorderid)
                {
                    return true;
                }
            }

            return false;
        }
        
        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }

        return false;
    }

    public static boolean check_available_orders()
    {
        String query;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            query = "SELECT * FROM customer_order_info WHERE `Customer Username` = '"+username+"';";

            ResultSet rs = st.executeQuery(query);
            
            if (rs.next())
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
        
        return false;
    }
    
    public static void communicate()
    {
        String option;

        try(Scanner sc = new Scanner(System.in))
        {
            System.out.println("\nWelcome to Communication Section!\n\nYour Message will be recorded and get response ASAP");
            System.out.print("\n[Enter Statement | Exit]\n\nEnter your option: ");
            
            option = sc.nextLine();

            if (option.toLowerCase().equals("enter statement") || option.toLowerCase().equals("enter"))
            {
                enter_statement();
            }

            else if (option.toLowerCase().equals("exit"))
            {
                user_main_page();
            }

            else
            {
                System.out.println("Invalid Input!");
                communicate();
            }
        }
        
        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }

    public static void enter_statement()
    {
        String messagetype, message, query;
        
        LocalDateTime timeofmessage = LocalDateTime.now();

        try(Scanner sc = new Scanner (System.in))
        {
            System.out.print("\n[Compliment | Feedback | Complaint | Help]\n\nEnter your reason: ");
            messagetype = sc.nextLine();
            System.out.println("\nEnter the Statement (Do not use single quotes( ' (or) '' ) & Do not exceed 255 letters): \n");
            message = sc.nextLine();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain_management", "root", "12345");
            Statement st = con.createStatement();

            query = "INSERT INTO communication_info (Username,`Message Type`,Message,`Time of Message`)Values('"+username+"','"+messagetype+"','"+message+"','"+timeofmessage+"')";

            st.executeUpdate(query);

            System.out.println("\n"+messagetype+" has been recorded! & you will recieve our response soon!");

            enter_statement();
        }

        catch(Exception e)
        {
            System.out.println("An Error Occured!");
        }
    }
}
