import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
//import java.sql.Statement; 

public class adminviewRes extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.print("<style>\r\n"
				+ "table {\r\n"
				+ "  font-family: arial, sans-serif;\r\n"
				+ "  border-collapse: collapse;\r\n"
				+ "  width: 100%;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "td, th {\r\n"
				+ "  border: 1px solid #dddddd;\r\n"
				+ "  text-align: left;\r\n"
				+ "  padding: 8px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "tr:nth-child(even) {\r\n"
				+ "  background-color: #dddddd;\r\n"
				+ "}\r\n"
				+ "</style>");
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","anuhyav","anuhya11421"); 
		String vsql = "select * from urbanspoonrestaurant";
		//urbanspoonrest is a table having valid restaurants and list of their branches
		Statement pstmt = con.createStatement();
		ResultSet rs = pstmt.executeQuery(vsql);
		RequestDispatcher rd = req.getRequestDispatcher("urbanspoon.html");
		rd.include(req,res);
		out.print("<table>\r\n"
				+ "  <tr>\r\n"
				+ "    <th>ID</th>\r\n"
				+ "    <th>Name</th>\r\n"
				+ "    <th>Branches</th>\r\n"
				+ "    <th>official_reg_id</th>\r\n"
				+ "  </tr></table>");
		out.println("</body>");
		out.println("<html>");
		con.close();
		}
		catch(Exception e){
		res.sendError(500,"Our application is failed due to:" + e);
		}
	}
}