import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import java.Candidates;

@WebServlet(
		name = "EditCandidates",
		urlPatterns = {"/editcandidates"}
		)
public class EditCandidates extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		//Create session
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				//Dao class needs get candidate info method!
				Dao dao = new Dao();
				Game game = dao.getGameInfo(id);
				
				session.setAttribute("game", game);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editCandidates.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showdata");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		
		// Create connection
		Dao dao=new Dao();
		Game game = readGame(request);
		
		dao.updateGame(game);
		
		dao.close();

		response.sendRedirect("/");  // redirect to candidates
	}
	
	private Game readGame(HttpServletRequest request) {
		Game game=new Game();
		game.setBreed(request.getParameter("breed"));
		game.setWeight(request.getParameter("weight"));
		game.setId(Integer.parseInt(request.getParameter("id")));
		return game;
	}
}
