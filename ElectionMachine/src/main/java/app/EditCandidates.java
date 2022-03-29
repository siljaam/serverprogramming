package app;

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
import app.Candidates;

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
			
				Dao dao = new Dao();
				Candidates candidates = dao.getCandidateInfo(id);
				
				session.setAttribute("candidate", candidates);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editCandidates.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// Create connection
		Dao dao=new Dao();
		Candidates candidate = readCandidates(request);
		
		dao.updateCandidate(candidate);
		
		dao.close();

		response.sendRedirect("/");  // redirect to candidates list
	}
	

	private Candidates readCandidates(HttpServletRequest request) {
		Candidates candidates=new Candidates();
		candidates.setEhdokas_id(Integer.parseInt(request.getParameter("id")));
		candidates.setEtunimi(request.getParameter("Etunimi"));
		candidates.setSukunimi(request.getParameter("Sukunimi"));
		candidates.setKotikunta(request.getParameter("Kotikunta"));
		candidates.setIka(Integer.parseInt(request.getParameter("id")));
		candidates.setEhdolle(request.getParameter("Ehdolle"));
		candidates.setEdistaa(request.getParameter("Edistaa"));
		
		return candidates;
	}
}
