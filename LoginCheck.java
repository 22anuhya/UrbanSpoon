import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
//import java.sql.Statement; 

public class LoginCheck extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","anuhyav","anuhya11421"); 
		String vsql = "select * from urbanspoonlogin where uname=? and pwd=?";
		PreparedStatement pstmt = con.prepareStatement(vsql);
		pstmt.setString(1,uname);
		pstmt.setString(2,pwd);
		ResultSet rs = pstmt.executeQuery();
		if( rs.next() ){
		req.setAttribute("uname",uname);
		RequestDispatcher rd = req.getRequestDispatcher("urbanspoon.html");
		rd.forward(req,res);
		}
		else{
		out.println("Invalid username/password<br>");
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req,res);
		}
		out.println("</body>");
		out.println("<html>");
		con.close();
		}
		catch(Exception e){
		res.sendError(500,"Our application is failed due to:" + e);
		}
	}
}