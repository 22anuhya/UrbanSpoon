import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
//import java.sql.Statement; 

public class addres extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		String email = req.getParameter("email");
		String resname = req.getParameter("resname");
		String resid = req.getParameter("resid");
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","anuhyav","anuhya11421"); 
		String vsql = "insert into urbanspoonrestaurant values(?,?,?,?,?,?)";
		//urbanspoonrest is a table having valid restaurants and list of their branches
		PreparedStatement pstmt = con.prepareStatement(vsql);
		pstmt.setString(1,name);
		pstmt.setString(2,uname);
		pstmt.setString(3,email);
		pstmt.setString(4,pwd);
		pstmt.setString(5,resname);
		pstmt.setString(6,resid);
		ResultSet rs = pstmt.executeQuery();
		out.println("Request sent Successfull!!<br>");
		RequestDispatcher rd = req.getRequestDispatcher("urbanspoon.html");
		rd.include(req,res);
		out.println("</body>");
		out.println("<html>");
		con.close();
		}
		catch(Exception e){
		res.sendError(500,"Our application is failed due to:" + e);
		}
	}
}