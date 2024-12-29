package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		out.println("<h2 align=center>Student Information System<h2>");
		out.println("<h2 align=center>Welcome Mr. " + userName + "</h4>");

		out.println("<hr/>");
		out.println("<hr/>");

		// out.println("<h3 align=center><a href=view?userName="+userName+">View
		// Profile</a></h3>");

		Connection con = DBConnection.getConnection();
		String query = "SELECT * FROM StudentDetails WHERE userName = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, userName);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int studentId = rs.getInt("studentId");
				String studentName = rs.getString("studentName");
				String password = rs.getString("password");
				String emailId = rs.getString("emailId");
				String mobileNo = rs.getString("mobileNo");
				String gender = rs.getString("gender");
				String languages = rs.getString("languages");
				String qualification = rs.getString("qualification");
				String comments = rs.getString("comments");

//				out.println("<table align='center' border='5'>" +
//
//						"<caption><h3>Student Details</h3></caption>" +
//
//						"<tr>" + "<th>Student Id</th>" + "<td>" + studentId + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Student Name</th>" + "<td>" + studentName + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>User Name</th>" + "<td>" + userName + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Password</th>" + "<td>" + password + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Email Id</th>" + "<td>" + emailId + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Mobile No</th>" + "<td>" + mobileNo + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Gender</th>" + "<td>" + gender + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Language</th>" + "<td>" + languages + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Qualification</th>" + "<td>" + qualification + "</td>" + "</tr>" +
//
//						"<tr>" + "<th>Comments</th>" + "<td>" + comments + "</td>" + "</tr>" +
//
//						"</table>");
				
				out.println("<!DOCTYPE html>");
				out.println("<html lang='en'>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
				out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
				out.println("<title>Student Details</title>");
				out.println("</head>");
				out.println("<body class='bg-light'>");

				out.println("<div class='container mt-5'>");
				out.println("<h3 class='text-center mb-4'>Student Details</h3>");
				out.println("<table class='table table-bordered table-striped'>");
				out.println("<thead class='thead-dark'>");
				out.println("<tr><th>Field</th><th>Value</th></tr>");
				out.println("</thead>");
				out.println("<tbody>");
				out.println("<tr><th>Student Id</th><td>" + studentId + "</td></tr>");
				out.println("<tr><th>Student Name</th><td>" + studentName + "</td></tr>");
				out.println("<tr><th>User Name</th><td>" + userName + "</td></tr>");
				out.println("<tr><th>Password</th><td>" + password + "</td></tr>");
				out.println("<tr><th>Email Id</th><td>" + emailId + "</td></tr>");
				out.println("<tr><th>Mobile No</th><td>" + mobileNo + "</td></tr>");
				out.println("<tr><th>Gender</th><td>" + gender + "</td></tr>");
				out.println("<tr><th>Language</th><td>" + languages + "</td></tr>");
				out.println("<tr><th>Qualification</th><td>" + qualification + "</td></tr>");
				out.println("<tr><th>Comments</th><td>" + comments + "</td></tr>");
				out.println("</tbody>");
				out.println("</table>");
				out.println("</div>");

				out.println("<footer class='bg-primary text-white text-center py-3 mt-4'>");
				out.println("&copy; Copyrights Reserved. Career IT Training");
				out.println("</footer>");

				out.println("</body>");
				out.println("</html>");

			}
		} catch (Exception e) {
			System.out.println("" + e);
		}

		out.println("<h3 align=center><a href=home?userName=" + userName + ">Back</a></h3>");

//		out.println("<hr/>");
//		out.println("<hr/>");
//		out.println("<h5 align=center>&copy; Copyrights Reserved.Carrer IT Training</h5>");
	}

}
