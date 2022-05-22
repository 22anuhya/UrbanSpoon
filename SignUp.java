import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
//import java.sql.Statement; 

public class SignUp extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		String email = req.getParameter("email");
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","anuhyav","anuhya11421"); 
		String vsql = "insert into urbanspoonsignup values(?,?,?,?)";
		String vsql1 = "insert into urbanspoonlogin values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(vsql);
		PreparedStatement pstmt1 = con.prepareStatement(vsql1);
		pstmt.setString(1,name);
		pstmt.setString(2,uname);
		pstmt.setString(3,email);
		pstmt.setString(4,pwd);
		pstmt1.setString(1,uname);
		pstmt1.setString(2,pwd);
		ResultSet rs = pstmt.executeQuery();
		ResultSet rs1 = pstmt1.executeQuery();
		out.println("Successful SignUp!!<br>");
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
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