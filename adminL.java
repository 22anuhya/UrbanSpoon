import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class adminL extends HttpServlet{
		public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","anuhyav","anuhya11421"); 
			if( uname.equals("Anuhya") && pwd.equals("anuhyavelagapudi")){
			req.setAttribute("uname",uname);
			RequestDispatcher rd = req.getRequestDispatcher("adminpage.html");
			rd.forward(req,res);
			}
			else{
			out.println("<p style='text-align:center;font-size:20px;'>Invalid Credentials</p><br>");
			RequestDispatcher rd = req.getRequestDispatcher("admin.html");
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
