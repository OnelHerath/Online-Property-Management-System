package controllerpackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Seller</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        seller e=DBConnect.getSellerById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>email:</td><td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>"); 
        out.print("<tr><td>phone:</td><td><input type='text' name='phone' value='"+e.getPhone()+"'/></td></tr>");
        out.print("<tr><td>location:</td><td><input type='text' name='location' value='"+e.getLocation()+"'/></td></tr>");
        out.print("<tr><td>message:</td><td><input type='text' name='message' value='"+e.getMessage()+"'/></td></tr>");
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
} 

