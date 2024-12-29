package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");

		out.println("<h2 align=center>Student Information System<h2>");
		out.println("<h2 align=center>Welcome Mr. " + userName + "</h4>");

		out.println("<hr/>");
		out.println("<hr/>");

		// out.println("<h3 align=center><a href=change?userName=" + userName + ">Change
		// Password</a></h3>");
//		out.println("<form action='editPassword' method='post'>" + "<input type='hidden' name='userName' value=" + userName + ">"
//				+ "<table align=center border=5>"
//				+ "<tr><th>Old Password:</th><td><input type=text name='oldPassword'></td></tr>"
//				+ "<tr><th>New Password:</th><td><input type=text name='newPassword'></td></tr>"
//				+ "<tr><th>Confirm Password:</th><td><input type=text name='confirmPassword'></td></tr>"
//				+ "<tr><th><input type=reset value=reset></th><td align=right><input type=submit value=change></td></tr>"
//				+ "</table>" + "</form>");
		
		out.println("<!DOCTYPE html>"
		        + "<html lang='en'>"
		        + "<head>"
		        + "<meta charset='UTF-8'>"
		        + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
		        + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css' rel='stylesheet'>"
		        + "<title>Change Password</title>"
		        + "</head>"
		        + "<body>"
		        + "<form action='editPassword' method='post' class='container mt-5'>"
		        + "<input type='hidden' name='userName' value='" + userName + "'>"
		        + "<div class='card shadow-sm p-4'>"
		        + "<h3 class='text-center mb-4'>Change Password</h3>"

		        + "<div class='mb-3'>"
		        + "<label for='oldPassword' class='form-label'>Old Password</label>"
		        + "<input type='password' class='form-control' id='oldPassword' name='oldPassword'>"
		        + "</div>"

		        + "<div class='mb-3'>"
		        + "<label for='newPassword' class='form-label'>New Password</label>"
		        + "<input type='password' class='form-control' id='newPassword' name='newPassword'>"
		        + "</div>"

		        + "<div class='mb-3'>"
		        + "<label for='confirmPassword' class='form-label'>Confirm Password</label>"
		        + "<input type='password' class='form-control' id='confirmPassword' name='confirmPassword'>"
		        + "</div>"

		        + "<div class='d-flex justify-content-between'>"
		        + "<button type='reset' class='btn btn-secondary'>Reset</button>"
		        + "<button type='submit' class='btn btn-primary'>Change</button>"
		        + "</div>"

		        + "</div>"
		        + "</form>"
		        + "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js'></script>"
		        + "</body>"
		        + "</html>");

		out.println("<h3 align=center><a href=home?userName="+userName+">Back</a></h3>");
		out.println("<hr/>");
		out.println("<hr/>");
		out.println("<footer align=center>&copy; Copyrights Reserved.Career IT Training</footer>");
	}


}
