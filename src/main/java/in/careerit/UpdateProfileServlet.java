package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProfileServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3 align=center>Landed on Update Profile servlet...</h3>");

		String userName = request.getParameter("userName");
		//out.println(userName);

//		if(true) {
//			RequestDispatcher rd=request.getRequestDispatcher("/view");
//			rd.include(request, response);
//			out.println("<h3 align=center>Updated sucessfully</h3>");
//			
//		}else{
//			out.println("<h3 align=center>Error on Updating</h3>");
//		}

		Connection con = DBConnection.getConnection();
		String studentName = request.getParameter("studentName");
		String emailId = request.getParameter("emailId");
		String mobileNo = request.getParameter("mobileNo");
		String gender = request.getParameter("gender");
		String languages = request.getParameter("languages");
		String qualification = request.getParameter("qualification");
		String comments = request.getParameter("comments");
		try {
			String uQuery = "UPDATE studentDetails set studentName=?,emailId=?,mobileNo=?,gender=?,languages=?,qualification=?,comments=? where userName=?";
			PreparedStatement pstmt = con.prepareStatement(uQuery);
			pstmt.setString(1, studentName);
			pstmt.setString(2, emailId);
			pstmt.setString(3, mobileNo);
			pstmt.setString(4, gender);
			pstmt.setNString(5, languages);
			pstmt.setString(6, qualification);
			pstmt.setString(7, comments);
			pstmt.setString(8, userName);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/view");
				rd.include(request, response);
				out.println("<h3 align=center style='color:green'>Profile Updated Successfully!</h3>");
			} else {
				out.println("<h3 align=center style='color:red'>Error Updating Profile!</h3>");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
