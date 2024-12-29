package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//Read form parameters
		String gameType=request.getParameter("gameType");
		
		
		//Populate a list of game based on game type
		ArrayList gameList=new ArrayList();
		if(gameType.equals("Indoor")) {
			gameList.add("Carrom");
			gameList.add("Badminton");
			gameList.add("Chess");
			
		}else {
			gameList.add("Cricket");
			gameList.add("Hockey");
			gameList.add("Football");
		}
		
		//Generate the response for the client
		out.println("<h3 align=center>Selected Game Type is :: "+gameType+"</h3>");
		out.println("<h3 align=center>List of Games are :: "+ gameList+"</h3>");;
	}

}
