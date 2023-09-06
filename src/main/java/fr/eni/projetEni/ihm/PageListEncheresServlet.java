package fr.eni.projetEni.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bll2.ArticleVendusManager;
import fr.eni.projetEni.bll2.ArticleVendusManagerSing;
import fr.eni.projetEni.bll2.ManagerException;
import fr.eni.projetEni.bo2.ArticlesVendu;
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
//	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();
	private ArticleVendusManager aManager = ArticleVendusManagerSing.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ArticlesVendu> lstArticle = new ArrayList<ArticlesVendu>();
		try {
			lstArticle = aManager.getAllArticlesVendus();
			request.setAttribute("articles", lstArticle);
		} catch (ManagerException e) {
			e.printStackTrace();
		}
		String url = request.getServletPath();
		if(url.equals("/ProjetEni/connexion")) {
			response.sendRedirect("/ProjetEni/acceuil");
		}
		if (url.equals("/ProjetEni/acceuil") || url.equals("/ProjetEni")) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("/ProjetEni/acceuil");
			return;
		} else {
			HttpSession session = request.getSession();
			if (session.getAttribute("utilisateurConnecte") == null) {
				session.invalidate();
				request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
			} else {
				// code generation des enchères connecter
//				Utilisateur utilisateur = new Utilisateur();
//				List<ArticlesVendu> lstArticleUtilisateur = new ArrayList<ArticlesVendu>();
//				
//				utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
//				Integer noUtilisateur = utilisateur.getNo_utilisateur();
//				
//				lstArticle.stream().filter(e -> e.getUtilisateur().getNo_utilisateur() == noUtilisateur)
//						.forEach(e -> lstArticleUtilisateur.add(e));
//
////				lstArticleUtilisateur.forEach(System.out::println);
//				request.setAttribute("articles", lstArticleUtilisateur);
				
				request.setAttribute("articles", lstArticle);
				request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String login = request.getParameter("login");
//		String password = request.getParameter("password");
//		HttpSession session = request.getSession();
//		Utilisateur utilisateur = new Utilisateur();
//		if(request.getParameter("deconnexion").equalsIgnoreCase("deconnexion")) {
//		System.out.println("test:  " + session.getAttribute("utilisateurConnecte").toString());
//			session.invalidate();
//		};
//
//		if (session.getAttribute("utilisateurConnecte") == null) {
//			request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
//		} else {
//			utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
//			try {
//				utilisateur = uManager.check(login, password);
//			} catch (ManagerException e) {
//				e.printStackTrace();
//			}
//
//			request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp").forward(request, response);
//		}

	}

}
