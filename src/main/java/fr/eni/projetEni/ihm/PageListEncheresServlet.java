package fr.eni.projetEni.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bll2.ArticleVendusManager;
import fr.eni.projetEni.bll2.ArticleVendusManagerSing;
import fr.eni.projetEni.bll2.CategorieManager;
import fr.eni.projetEni.bll2.CategorieManagerSing;
import fr.eni.projetEni.bll2.ManagerException;
import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Categorie;
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
	private CategorieManager cManager = CategorieManagerSing.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ArticlesVendu> lstArticle = new ArrayList<ArticlesVendu>();
		List<Categorie> lstCategorie = new ArrayList<Categorie>();
		try {
			lstArticle = aManager.getAllArticlesVendus();
			request.setAttribute("articles", lstArticle);
		} catch (ManagerException e) {
			e.printStackTrace();
		}
		try {
			lstCategorie = cManager.getAllCategories();
			request.setAttribute("categories", lstCategorie);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String url = request.getServletPath();

		if (url.equals("/ProjetEni/acceuil") || url.equals("/ProjetEni")) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("/ProjetEni/acceuil");
			return;
		} else {
			HttpSession session = request.getSession();
			if (session.getAttribute("utilisateurConnecte") == null) {
				session.invalidate();
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
			}
			request.getRequestDispatcher("/WEB-INF/pageListEncheres.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String btn = request.getParameter("btnRechercher");
		List<ArticlesVendu> lstArticle = new ArrayList<ArticlesVendu>();
		List<ArticlesVendu> lstArticleFiltre = new ArrayList<ArticlesVendu>();
		List<Categorie> lstCategorie = new ArrayList<Categorie>();
		String categorie = request.getParameter("categorie");
		String bAchats = request.getParameter("achat");
		try {
			lstCategorie = cManager.getAllCategories();
			request.setAttribute("categories", lstCategorie);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			lstArticle = aManager.getAllArticlesVendus();
//			lstArticle = lstArticle.stream().filter(e->  e.getCategorie().getNo_categorie() == 16).forEach(e -> System.out.println("testt: "+ e.getCategorie().getLibelle()));
			if(categorie.isBlank()) {
				request.setAttribute("articles", lstArticle);
				request.setAttribute("categorie", categorie);
			}else {
				lstArticle.stream().filter(e->  e.getCategorie().getNo_categorie() == Integer.valueOf(categorie)).forEach(e -> lstArticleFiltre.add(e));
				request.setAttribute("articles", lstArticleFiltre);
				request.setAttribute("categorie",categorie);
			}
		} catch (ManagerException e) {
			e.printStackTrace();
		}
		
		if (session.getAttribute("utilisateurConnecte") == null) {
		} else {
		}
		request.getRequestDispatcher("/WEB-INF/pageListEncheres.jsp").forward(request, response);

	}

}
