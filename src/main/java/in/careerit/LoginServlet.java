package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Read from parameters
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		Connection con=DBConnection.getConnection();
		String query="SELECT * FROM StudentDetails Where userName=? AND password=?";
		try {
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				//out.println("<h4 align=center>login sucess</h4>");
				response.sendRedirect("home?userName="+userName);
//				RequestDispatcher rd=request.getRequestDispatcher("home");
//				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				out.println("<h4 align=center>Invalid Credentials.Try again...</h4>");
			}
		}catch(SQLException e){
			out.println("Exception "+e);
		}		
		
		
//		out.println("<table align='center' border='5'>" +
//
//				"<caption><h3>Login Details</h3></caption>" +
//
//				"<tr>" + "<th>User Name</th>" + "<td>" + userName + "</td>" + "</tr>" +
//				
//				"</table>"
//				);
	}

}
