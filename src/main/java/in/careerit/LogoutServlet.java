package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

//		out.println("<h3 align=center>Logged out sucessfully</h3>");
//		out.println("<h3 align=center>Click here to <a href=Login.html>Login</a></h3>");
//		

		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("    <meta charset='UTF-8'>");
		out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("    <title>Logout</title>");
		out.println("    <!-- Bootstrap CSS -->");
		out.println(
				"    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <div class='container text-center mt-5'>");
		out.println("        <h3 class='text-success'>Logged out successfully</h3>");
		out.println("        <p>");
		out.println("            <a href='Login.html' class='btn btn-primary'>Login</a>");
		out.println("        </p>");
		out.println("    </div>");
		out.println("    <script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>");
		out.println(
				"    <script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js'></script>");
		out.println("    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
		out.println("</body>");
		out.println("</html>");

	}
}
