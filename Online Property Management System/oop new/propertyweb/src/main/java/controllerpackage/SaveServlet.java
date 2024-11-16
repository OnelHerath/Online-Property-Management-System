package controllerpackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String email=request.getParameter("email");  
        String phone=request.getParameter("phone");  
        String location=request.getParameter("location");
        String message=request.getParameter("message");
          
        seller e=new seller();  
        e.setName(name);  
        e.setEmail(email);  
        e.setPhone(phone);  
        e.setLocation(location);
        e.setMessage(message); 
          
        int status=DBConnect.save(e);  
        if(status>0){  
            out.print("<p>Record Saved Successfully!</p>");  
            request.getRequestDispatcher("seller.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
} 