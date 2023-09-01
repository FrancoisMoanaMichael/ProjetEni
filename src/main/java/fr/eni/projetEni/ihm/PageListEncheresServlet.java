package fr.eni.projetEni.ihm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/acceuil")
public class PageListEncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();

		if (url.equals("/acceuil")) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		HttpSession session = request.getSession();
		System.out.println("utilisateur session: " + session.getAttribute("utilisateurConnecte"));
		if (session.getAttribute("utilisateurConnecte") == null) {
			request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp").forward(request, response);
		}
		
	}

}
