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

public class EditPasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		if (!newPassword.equals(confirmPassword)) {
			out.println("<h3 align=center style='color:red;'>New Password and Confirm Password do not match!</h3>");
			out.println("<h3 align=center><a href=home?userName=" + userName + ">Back</a></h3>");
			return;
		}

		Connection con = DBConnection.getConnection();
		try {

			String chQuery = "SELECT password FROM StudentDetails WHERE userName=?";
			PreparedStatement chStmt = con.prepareStatement(chQuery);
			chStmt.setString(1, userName);

			ResultSet rs = chStmt.executeQuery();

			if (rs.next()) {
				String currentPassword = rs.getString("password");
				if (!currentPassword.equals(oldPassword)) {
					out.println("<h3 align=center style='color:red;'>Old Password is incorrect!</h3>");
					out.println("<h3 align=center><a href=home?userName=" + userName + ">Back</a></h3>");
					return;
				}
			} else {
				out.println("<h3 align=center style='color:red;'>User does not exist!</h3>");
				out.println("<h3 align=center><a href=home?userName=" + userName + ">Back</a></h3>");
				return;
			}

			String query = "UPDATE StudentDetails set password=? where userName=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, newPassword);
			stmt.setString(2, userName);

			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				out.println("<h3 align=center style='color:green;'>Password changed successfully!</h3>");
			} else {
				out.println("<h3 align=center style='color:red;'>Failed to change password. Try again later.</h3>");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		out.println("<h3 align=center><a href=home?userName=" + userName + ">Back</a></h3>");

		out.println("<hr/>");
		out.println("<hr/>");
		out.println("<h5 align=center>&copy; Copyrights Reserved.Carrer IT Training</h5>");
	}


}
