package fr.eni.projetEni.ihm;

import java.io.IOException;

import fr.eni.projetEni.bll.ManagerException;
import fr.eni.projetEni.bll.UtilisateurManager;
import fr.eni.projetEni.bll.UtilisateurManagerSing;
import fr.eni.projetEni.bo2.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/")
public class PageListEncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();

		if (url.equals("/ProjetEni/acceuil")) {
		HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("/ProjetEni/acceuil");
			return;
		} else {
		HttpSession session = request.getSession();
		
			if (session.getAttribute("utilisateurConnecte") == null) {
				System.out.println(session.getAttribute("utilisateurConnecte"));
				session.invalidate();
				request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
			} else {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");

				request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Utilisateur utilisateur = new Utilisateur();
		if(request.getParameter("deconnexion").equalsIgnoreCase("deconnexion")) {
		System.out.println("test:  " + session.getAttribute("utilisateurConnecte").toString());
			session.invalidate();
		};

		if (session.getAttribute("utilisateurConnecte") == null) {
			request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
		} else {
			utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
			try {
				utilisateur = uManager.check(login, password);
			} catch (ManagerException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp").forward(request, response);
		}

	}

}
