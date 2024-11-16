package controllerpackage;

import java.util.*;  
import java.sql.*;  
  
public class DBConnect { 
	
	
	  public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdatabase","root","123456");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
    
    public static int save(seller e){  
        int status=0;  
        try{  
            Connection con=DBConnect.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into landseller(name,email,phone,location,message) values (?,?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getPhone());  
            ps.setString(4,e.getLocation());
            ps.setString(5,e.getMessage());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(seller e){  
        int status=0;  
        try{  
            Connection con=DBConnect.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update landseller set name=?,email=?,phone=?,location=? message=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getPhone());  
            ps.setString(4,e.getLocation());
            ps.setString(5,e.getMessage());
            ps.setInt(6,e.getId());
            
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=DBConnect.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from landseller where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static seller getSellerById(int id){  
    	seller e=new seller();  
          
        try{  
            Connection con=DBConnect.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from landseller where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setName(rs.getString(1));  
                e.setEmail(rs.getString(2));  
                e.setPhone(rs.getString(3));  
                e.setLocation(rs.getString(4));  
                e.setMessage(rs.getString(5));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<seller> getAllSellers(){  
        List<seller> list=new ArrayList<seller>();  
          
        try{  
            Connection con=DBConnect.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from landseller");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	seller e=new seller();  
                e.setName(rs.getString(1));  
                e.setEmail(rs.getString(2));  
                e.setPhone(rs.getString(3));  
                e.setLocation(rs.getString(4));  
                e.setMessage(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
} 
