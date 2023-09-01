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
@WebServlet("/acceuil")
public class PageListEncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();

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
		Utilisateur utilisateur= new Utilisateur();
		System.out.println(session.getAttribute("utilisateurConnecte").toString());
		
		if (session.getAttribute("utilisateurConnecte") == null) {
			request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
		} else {
			Utilisateur utilisateur = session.getAttribute("utilisateurConnecte");
			try {
				utilisateur = uManager.check(login,password);
			} catch (ManagerException e) {
				e.printStackTrace();
			} 
			
			request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp").forward(request, response);
		}
		
	}

}
