import java.sql.*;
public class day23
{
    public static void main (String [] args)
    {   //Insert Data into Database
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","12345");
            Statement st = con.createStatement();
            int rs = st.executeUpdate("INSERT INTO info value (0003,'Prakash','ZF')");
            System.out.println("No.of.rows Inserted: "+rs);
            // Update data in Database:
            int rs1 = st.executeUpdate("Update info set Company = 'IBM' where id = 0001");
            System.out.println("No.of.rows updated: "+rs1);
            // Delete row:
            int rs2 = st.executeUpdate("Delete from info where id = 0003");
            System.out.println("No.of.rows Deleted: "+rs2);
            System.out.println("Query Executed Successfully!!");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
