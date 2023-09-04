package fr.eni.projetEni.ihm;

import java.io.IOException;

import fr.eni.projetEni.bll.ManagerException;
import fr.eni.projetEni.bll.UtilisateurManager;
import fr.eni.projetEni.bll.UtilisateurManagerSing;
import fr.eni.projetEni.bo2.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();

	/**
	 * @throws jakarta.servlet.ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, jakarta.servlet.ServletException {
		request.getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
	}

	/**
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		boolean rememberMe = request.getParameter("rememberMe") != null;

		Utilisateur utilisateur = new Utilisateur();

		try {
			utilisateur = uManager.check(login, password);
		} catch (ManagerException e) {
			e.printStackTrace();
		}

		if (utilisateur.getNom() == null) {
			if (login == "" || password == "") {
				request.setAttribute("message", "champs vide");
			} else {
				request.setAttribute("message", "utilisateur inconnnu");
			}
			request.getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
		} else {
			session.setAttribute("utilisateurConnecte", utilisateur);
			if (rememberMe) {
				session.setAttribute("rememberMe", true);
			} else {
				session.setAttribute("rememberMe", false);
			}
			request.setAttribute("message", "");

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp");
			rd.forward(request, response);
		}

	}
}
