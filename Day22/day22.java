import java.sql.*; 
public class day22 
{ 
    public static void main(String[] args) 
    {   //Show data from database
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "12345");
            Statement st = con .createStatement();
            ResultSet rs = st.executeQuery("SELECT * from info");
            
            while (rs.next())
            {
                System.out.println("\nEmployee ID: "+rs.getInt(1));
                System.out.println("Employee Name: "+rs.getString(2));
                System.out.println("Employee Company: "+rs.getString(3));
            }
            System.out.println("\nCommands Executed Successfully");
        }
        catch (ClassNotFoundException | SQLException e) 
        {    
            System.out.println(e);
        }
    }
}

/*
 * JDBC: Java Database Connectivity
 * Database:
 * Collection of Data
 * 
 * MySql -- Commands:
 * 1) DDL --> Data Definition Lnaguage
 * 2) DML --> Data Manipulation Language
 * 3) DCL --> Data Control language
 * 4) TCL --> Transaction Control Language
 * 
 *  CRUD:
 *  Create, Read, Update, Delete.
 * 
 *  JDBC Connection Steps:
 * 1) import package
 * 2) load and register the Driver class
 * 3) Connecting Data base
 * 4) Write a Query
 * 5) Execute Query
 * 6) Process the Result
 * 7) Closing the Connection
 *  
 * Syntax:
 * public class JDBC
 * {
 *      Public static void main (String [] args)
 * {
 * // Step1: --> Load the Driver Class
 *      Class.ForName("com.mysql.cj.jdbc.Driver");
 * 
 * // Step2: --> Create connection object
 *      Connection con = DriverManager.getConnection 
 *  ("jdbc:mysql://localhost:3306/mydatabase3","root","12345");
 * 
 * // Step 3: Create Statement Object;
 *      Statement st = con.createStatement();
 * 
 * // Step 4: Execute the Query
 *      ResultSet rs = st.executeQuery("SELECT * FROM info")
 * 
 *         
 * }
 * }
 */
