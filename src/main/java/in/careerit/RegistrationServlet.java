package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Read from parameters
		try {
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			String studentName = request.getParameter("studentName");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String emailId = request.getParameter("emailId");
			String mobileNo = request.getParameter("mobileNo");
			String gender = request.getParameter("gender");
			String[] languages = request.getParameterValues("languages");
			String qualification = request.getParameter("qualification");
			String comments = request.getParameter("comments");

//			out.println("<table align='center' border='5'>" +
//
//					"<caption><h3>Student Details</h3></caption>" +
//
//					"<tr>" + "<th>Student Id</th>" + "<td>" + studentId + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Student Name</th>" + "<td>" + studentName + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>User Name</th>" + "<td>" + userName + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Password</th>" + "<td>" + password + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Email Id</th>" + "<td>" + emailId + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Mobile No</th>" + "<td>" + mobileNo + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Gender</th>" + "<td>" + gender + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Language</th>" + "<td>" + Arrays.toString(languages) + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Qualification</th>" + "<td>" + qualification + "</td>" + "</tr>" +
//
//					"<tr>" + "<th>Comments</th>" + "<td>" + comments + "</td>" + "</tr>" +
//
//					"</table>");

			// DB Connection
			Connection con = DBConnection.getConnection();
			String query = "INSERT INTO StudentDetails VALUES(?,?,?,?,?,?,?,?,?,?) ";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, studentId);
				pstmt.setString(2, studentName);
				pstmt.setString(3, userName);
				pstmt.setString(4, password);
				pstmt.setString(5, emailId);
				pstmt.setString(6, mobileNo);
				pstmt.setString(7, gender);
				pstmt.setString(8, Arrays.toString(languages));
				pstmt.setString(9, qualification);
				pstmt.setString(10, comments);

				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected > 0) {
					RequestDispatcher rd=request.getRequestDispatcher("view");
					rd.include(request, response);
					
					out.println("<h4 align=center>Registration completed sucessfully</h4>");
					out.println("<h4 align=center>Click Here<a href='Login.html'> to Login</h4>");
				} else {
					System.out.println("<h3 align=center style='color:red;'>Failed to update</h3>");
				}

			} catch (SQLException e) {
				System.out.println("Error: " + e);
			}
		} catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("Registration.html");
			rd.include(request, response);
			out.println("<h4 align=center>Enter Details correctly..!</h4>");
		}

	}

}

/*
 * CREATE TABLE StudentDetails (StudentId number(4) ,StudentName varchar2(15)
 * ,userName varchar2(12) ,password varchar2(12) ,EmailId varchar2(30) ,mobileNo
 * varchar2(10) ,gender varchar2(6) ,languages varchar2(30) ,qualification
 * varchar2(20) ,comments varchar2(30)) /
 */