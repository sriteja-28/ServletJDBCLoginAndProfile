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

public class EditProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName=request.getParameter("userName");
		out.println("<h2 align=center>Student Information System<h2>");
		out.println("<h2 align=center>Welcome Mr. "+userName+"</h4>");
		
		out.println("<hr/>");
		out.println("<hr/>");
		

		//out.println("<h3 align=center><a href=edit?userName="+userName+">Edit Profile</a></h3>");
		Connection con = DBConnection.getConnection();
		String query = "SELECT * FROM StudentDetails WHERE userName = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, userName);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int studentId = rs.getInt("studentId");
				String studentName = rs.getString("studentName");
				String emailId =rs.getString("emailId");
				String mobileNo =rs.getString("mobileNo");
				String gender =rs.getString("gender");
				String languages = rs.getString("languages");
				
				String qualification = rs.getString("qualification");
				String comments = rs.getString("comments");
				
//				out.println("<form action='update' method='post'>"
//						+ "<table align='center' border='5'>" +
//
//						"<caption><h3>Student Details</h3></caption>" +
//
//						"<tr>" + "<th>Student Id</th>" + "<td><input type='text' name='studentId' value="+ studentId+" readonly></td>"+ "</tr>" +
//
//						"<tr>" + "<th>Student Name</th>" + "<td><input type='text' name='studentName' value="+ studentName+"></td>" + "</tr>" +
//
//						"<tr>" + "<th>User Name</th>" +  "<td><input type='text' name='userName' value="+userName+" readonly></td>" + "</tr>" +
//
//						"<tr>" + "<th>Email Id</th>" + "<td><input type='text' name='emailId' value="+ emailId+" ></td>" + "</tr>" +
//
//						"<tr>" + "<th>Mobile No</th>" +  "<td><input type='text' name='mobileNo' value="+ mobileNo+" ></td>" + "</tr>" +
//
//						"<tr>" + "<th>Gender</th>" +  "<td><input type='text' name='gender' value="+ gender+" ></td>" + "</tr>" +
//
//						"<tr>" + "<th>Language</th>" + "<td><input type='text' name='languages' value='"+languages+"'></td>" + "</tr>" +
//
//						"<tr>" + "<th>Qualification</th>" +  "<td><input type='text' name='qualification' value="+ qualification+"></td>"+ "</tr>" +
//
//						"<tr>" + "<th>Comments</th>" +  "<td><input type='text' name='comments' value="+ comments+"></td>" + "</tr>" +
//
//						"<tr>" + "<td><input type='reset' value='Reset'/></td>" +  "<td align='right'><input type='submit' value='update'/></td>" + "</tr>" +
//
//						"</table>");
				
				out.println("<!DOCTYPE html>"
				        + "<html lang='en'>"
				        + "<head>"
				        + "<meta charset='UTF-8'>"
				        + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
				        + "<title>Student Details</title>"
				        + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css' rel='stylesheet'>"
				        + "</head>"
				        + "<body class='bg-light'>"
				        + "<div class='container mt-5'>"
				        + "<div class='card shadow-sm'>"
				        + "<div class='card-header text-center bg-primary text-white'>"
				        + "<h3>Student Details</h3>"
				        + "</div>"
				        + "<div class='card-body'>"
				        + "<form action='update' method='post'>"
				        + "<div class='mb-3'>"
				        + "<label for='studentId' class='form-label'>Student Id</label>"
				        + "<input type='text' class='form-control' id='studentId' name='studentId' value='" + studentId + "' readonly>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='studentName' class='form-label'>Student Name</label>"
				        + "<input type='text' class='form-control' id='studentName' name='studentName' value='" + studentName + "'>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='userName' class='form-label'>User Name</label>"
				        + "<input type='text' class='form-control' id='userName' name='userName' value='" + userName + "' readonly>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='emailId' class='form-label'>Email Id</label>"
				        + "<input type='email' class='form-control' id='emailId' name='emailId' value='" + emailId + "'>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='mobileNo' class='form-label'>Mobile No</label>"
				        + "<input type='text' class='form-control' id='mobileNo' name='mobileNo' value='" + mobileNo + "'>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='gender' class='form-label'>Gender</label>"
				        + "<input type='text' class='form-control' id='gender' name='gender' value='" + gender + "'>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='languages' class='form-label'>Languages</label>"
				        + "<input type='text' class='form-control' id='languages' name='languages' value='" + languages + "'>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='qualification' class='form-label'>Qualification</label>"
				        + "<input type='text' class='form-control' id='qualification' name='qualification' value='" + qualification + "'>"
				        + "</div>"
				        + "<div class='mb-3'>"
				        + "<label for='comments' class='form-label'>Comments</label>"
				        + "<input type='text' class='form-control' id='comments' name='comments' value='" + comments + "'>"
				        + "</div>"
				        + "<div class='d-flex justify-content-between'>"
				        + "<button type='reset' class='btn btn-secondary'>Reset</button>"
				        + "<button type='submit' class='btn btn-primary'>Update</button>"
				        + "</div>"
				        + "</form>"
				        + "</div>"
				        + "</div>"
				        + "</div>"
				        +"<footer class='bg-primary text-white text-center mt-5 py-3'>"
						+"&copy; Copyrights Reserved. Career IT Training"
						+"</footer>"
				        + "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js'></script>"
				        + "</body>"
				        + "</html>");

				
			}
		} catch (Exception e) {
			System.out.println("" + e);
		}

		
		out.println("<h3 align=center><a href=home?userName="+userName+">Back</a></h3>");
		
//		out.println("<hr/>");
//		out.println("<hr/>");
//		out.println("<h5 align=center>&copy; Copyrights Reserved.Carrer IT Training</h5>");
	}	

}
