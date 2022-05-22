import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
//import java.sql.Statement; 

public class price extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<h1 style='text-align:center'>Book Restaurant!!</h1><br>");
		out.print("<form><h2>Name : <input name='name'></h2><br>");
		out.print("<form><h2>Restaurant : <input name='restaurant'></h2><br>");
		out.print("<form><h2>price : <input name='rate'></h2><br></form>");
		String name=req.getParameter("name");
		String address = req.getParameter("address");
		String rate = req.getParameter("rate");
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","anuhyav","anuhya11421"); 
		out.println("</body>");
		out.println("<html>");
		con.close();
		}
		catch(Exception e){
		res.sendError(500,"Our application is failed due to:" + e);
		}
	}
}