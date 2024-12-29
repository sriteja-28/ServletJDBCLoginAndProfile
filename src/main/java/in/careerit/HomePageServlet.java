package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName=request.getParameter("userName");
//		out.println("<h2 align=center>Student Information System<h2>");
//		out.println("<h2 align=center>Welcome Mr. "+userName+"</h4>");
//		
//		out.println("<hr/>");
//		out.println("<hr/>");
//		
//		out.println("<h3 align=center><a href=view?userName="+userName+">View Profile</a></h3>");
//		out.println("<h3 align=center><a href=edit?userName="+userName+">Edit Profile</a></h3>");
//		out.println("<h3 align=center><a href=change?userName="+userName+">Change Password</a></h3>");
//		out.println("<h3 align=center><a href=logout?userName="+userName+">Log out</a></h3>");
//		
//		out.println("<hr/>");
//		out.println("<hr/>");
//		out.println("<footer align=center>&copy; Copyrights Reserved.Career IT Training</footer>");
//		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		out.println("<title>Student Information System</title>");
		out.println("</head>");
		out.println("<body class='bg-light'>");

		
		out.println("<nav class='navbar navbar-expand-lg navbar-dark bg-primary'>");
		out.println("<a class='navbar-brand' href='#'>Student Information System</a>");
		out.println("</nav>");

		
		out.println("<div class='container text-center mt-4'>");
		out.println("<h2>Welcome, Mr. " + userName + "</h2>");
		out.println("</div>");

		
		out.println("<hr class='my-4'>");

		
		out.println("<div class='container text-center'>");
		out.println("<div class='row'>");
		out.println("<div class='col-md-3'><a href='view?userName=" + userName + "' class='btn btn-primary btn-block'>View Profile</a></div>");
		out.println("<div class='col-md-3'><a href='edit?userName=" + userName + "' class='btn btn-success btn-block'>Edit Profile</a></div>");
		out.println("<div class='col-md-3'><a href='change?userName=" + userName + "' class='btn btn-warning btn-block'>Change Password</a></div>");
		out.println("<div class='col-md-3'><a href='logout?userName=" + userName + "' class='btn btn-danger btn-block'>Log Out</a></div>");
		out.println("</div>");
		out.println("</div>");

		
		out.println("<footer class='bg-primary text-white text-center mt-5 py-3'>");
		out.println("&copy; Copyrights Reserved. Career IT Training");
		out.println("</footer>");

		out.println("</body>");
		out.println("</html>");

	}
}
