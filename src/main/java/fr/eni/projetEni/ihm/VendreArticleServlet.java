package fr.eni.projetEni.ihm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEni.bll2.ArticleVendusManager;
import fr.eni.projetEni.bll2.ArticleVendusManagerSing;
import fr.eni.projetEni.bll2.CategorieManager;
import fr.eni.projetEni.bll2.CategorieManagerSing;
import fr.eni.projetEni.bll2.ManagerException;
import fr.eni.projetEni.bll2.RetraisManager;
import fr.eni.projetEni.bll2.RetraisManagerSing;
import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Categorie;
import fr.eni.projetEni.bo2.Retrait;
import fr.eni.projetEni.bo2.Utilisateur;

/**
 * Servlet implementation class VendreArticle
 */
@WebServlet("/vendre_un_article")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVendusManager 	AVManager	= ArticleVendusManagerSing.getInstance();
	private RetraisManager			rManager	= RetraisManagerSing.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afficherCategories(request);
		try {
			AVManager.majTransactions();
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageVendreUnArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
		ArticlesVendu	newArticle	= null;
		Retrait			newRetrait	= null;
		Categorie		categorie	= new Categorie();
		categorie.setNo_categorie(Integer.parseInt(request.getParameter("categorie")));
			
		if (session.getAttribute("utilisateurConnecte") == null) {
			System.out.println(session.getAttribute("utilisateurConnecte"));
			session.invalidate();
			request.getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
		} else {
			try {
				newArticle = new ArticlesVendu(
						request.getParameter("nom_article"),
						request.getParameter("description"),
						LocalDate.parse(request.getParameter("date_debut_encheres")),
						LocalDate.parse(request.getParameter("date_fin_encheres")),
						Integer.parseInt(request.getParameter("prix_initial")));
				newArticle.setCategorie(categorie);
				newArticle.setUtilisateur(utilisateur);
				
				newRetrait = new Retrait(request.getParameter("rue"), request.getParameter("code_postal"), request.getParameter("ville"));
			} catch (NumberFormatException e) {
				request.setAttribute("message", "L'un des champs saisi doit contenir un numérique");
			}
			
			try {
				AVManager.addArticlesVendus(newArticle);
				newRetrait.setArticle(newArticle);
				rManager.addRetraits(newRetrait);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp");
				rd.forward(request, response);
			} catch (ManagerException e) {
				request.setAttribute("message", e);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageVendreUnArticle.jsp");
				rd.forward(request, response);
			}
		}
	}
	
	private void afficherCategories(HttpServletRequest request) {
		CategorieManager cManager = CategorieManagerSing.getInstance();
		List<Categorie> categories = new ArrayList<Categorie>();
		
		try {
			categories = cManager.getAllCategories();
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("categories", categories);
	}
}
