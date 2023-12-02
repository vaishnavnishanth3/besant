import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class day25 extends HttpServlet
{
    String data;
    public void init()
    {
        data = "Welcome to Besant Technologies";
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        res.setContentType("text/html");
        try (PrintWriter p = res.getWriter()) {
            p.print("<h1>"+data+"</h1>");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

/*
 * Web Application:
 * A web Application is a application that accessible for the web
 * 
 * Servlet:
 * A Servlet is used to create a web Application.
 * Java is a Server-side programming.
 * 
 * Servlet objects:
 * 1) request --> handle the request from the client
 * 2) response --> genrates the response to the server
 * 
 * servlet methods:
 * 1) init()
 * 
 * 2) service()
 * a) doget()
 * b) doPost()
 * 
 * 3) destory()
 * 
 * files:
 * 1) HTML
 * 2) XML --> web.xml
 * 3) java
 * 
 */