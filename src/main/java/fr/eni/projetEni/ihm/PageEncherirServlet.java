package fr.eni.projetEni.ihm;

import java.io.IOException;
import java.util.List;

import fr.eni.projetEni.bll2.ArticleVendusManager;
import fr.eni.projetEni.bll2.ArticleVendusManagerSing;
import fr.eni.projetEni.bll2.EnchereManager;
import fr.eni.projetEni.bll2.EnchereManagerSing;
import fr.eni.projetEni.bll2.ManagerException;
import fr.eni.projetEni.bo2.ArticlesVendu;
import fr.eni.projetEni.bo2.Enchere;
import fr.eni.projetEni.bo2.Utilisateur;
import fr.eni.projetEni.dal2.DalException;
import fr.eni.projetEni.dal2.EncheresDAOImpl;
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
@WebServlet("/encherir/*")
public class PageEncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();
	private EnchereManager eManager = EnchereManagerSing.getInstance();
	private ArticleVendusManager aManager = ArticleVendusManagerSing.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		String id = null;
		if (pathParts.length > 1) {
			id = pathParts[1];
		}

		if (id != null) {
			ArticlesVendu article = null;
			int idArticle = Integer.valueOf(id);
			try {
				article= aManager.getFullArticlesVendus(idArticle);
			} catch (Exception e) {
			}
		
			
			System.out.println("articlesdsfqsdf " + article.getNomCategorie());
			request.setAttribute("article", article);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageEncherir.jsp");
			rd.forward(request, response);

		} else {
			// Gérez ici le cas où l'ID est null si nécessaire
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
		HttpSession session = request.getSession(false);
		request.setAttribute("erreur", "salut");
//
		String id_enchere = request.getParameter("id_enchere");
		int num = Integer.parseInt(id_enchere);

		if (session.getAttribute("utilisateurConnecte") == null) {
			session.invalidate();
			request.setAttribute("erreur", "Merci de vous connecter!");
			response.sendRedirect("/ProjetEni/encherir/" + num);
			return;
		} else {

			Utilisateur utilisateur = new Utilisateur();
			utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");

//			String montant = request.getParameter("montant");
			int montantPoints = Integer.parseInt(request.getParameter("montant"));
			
			System.out.println("points: "+ montantPoints+ " idUtilisateur: "+utilisateur.getNo_utilisateur()+"nbpoint: "+ utilisateur.getCredit());
//			EncheresDAOImpl encheresDAO = new EncheresDAOImpl();
//			Enchere enchere = null;
			ArticlesVendu article = null;
			try {
				article= aManager.getFullArticlesVendus(num);
			} catch (Exception e) {
			}
			System.out.println("article avant "+article.getPrix_vente());
			article.setPrix_vente(montantPoints);
			System.out.println("article après "+article.getPrix_vente());
			if(utilisateur.getCredit() >= montantPoints) {
				try {
					aManager.majArticlesVendus(article);
				} catch (ManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				request.setAttribute("erreur", "t'es trop pauvre mon vieux..");
				
			}
//			try {
//				enchere= eManager.findEnchereByArticleId(num);
//				System.out.println(enchere);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//			if (enchere.getMontant_enchere() >= montant_int) {
//				request.setAttribute("erreur", "Merci de mettre un montant plus élevé que l'offre en cours!");
//				response.sendRedirect("/ProjetEni/encherir/" + num);
//				return;
//			}
//
//			if (enchere.getMontant_enchere() <= utilisateur.getCredit()) {
//				request.setAttribute("erreur", "Vous n'avez pas assez de crédit!");
//				response.sendRedirect("/ProjetEni/encherir/" + num);
//				return;
//			}

//			try {
//				enchere.setNo_utilisateur(num);
//				enchere.setMontant_enchere(montant_int);
//				encheresDAO.update(enchere);
//			} catch (DalException e) {
//				request.setAttribute("erreur", "Erreur lors de la mise à jour de l'enchère");
//				e.printStackTrace();
//			}
		System.out.println("coucou");
			response.sendRedirect("/ProjetEni/encherir/" + num);
			return;

		}

	}

}