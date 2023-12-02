package Day27;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class day27 extends HttpServlet
{
    String data;
    public void init()
    {
        data = "welcome to Besant Technologies";
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        res.setContentType("text/html");
        try (PrintWriter p = res.getWriter()) 
        {
            p.print("<h1>"+data+"</h1>");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        
    }
}
