package controllerpackage;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='seller.html'>Add New Land</a>");  
        out.println("<h1>Land Details</h1>");  
          
        List<seller> list=DBConnect.getAllSellers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>name</th><th>email</th><th>phone</th><th>location</th><th>message</th><th>"
        		  + "<th>Edit</th><th>Delete</th></tr>");  
        for(seller e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getLocation()+"</td><td>"+e.getMessage()+"<td><a href='DeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
