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
			EncheresDAOImpl encheresDAO = new EncheresDAOImpl();
			int num = Integer.parseInt(id);
			
			Enchere enchere = null;
			try {
				enchere = encheresDAO.findEnchereById(num);
				System.out.println("test encheres : "+String.valueOf(enchere));
			} catch (DalException e) {
				e.printStackTrace();
			}
			request.setAttribute("enchere", enchere);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageEncherir.jsp");
			rd.forward(request, response);

		} else {
			// Gérez ici le cas où l'ID est null si nécessaire
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		// Utilisateur utilisateur = new Utilisateur();
		request.setAttribute("erreur", "salut");

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

			String montant = request.getParameter("montant");

			int montant_int = Integer.parseInt(montant);

			EncheresDAOImpl encheresDAO = new EncheresDAOImpl();
			ArticlesVendu article = null;
			List<Enchere> enchere = null;
			try {
				article = aManager.getArticlesVendus(num);
			} catch (ManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				enchere= eManager.getEncheresByArticleID(num);
				enchere.forEach(System.out::println);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if (enchere.getMontant_enchere() >= montant_int) {
				request.setAttribute("erreur", "Merci de mettre un montant plus élevé que l'offre en cours!");
				response.sendRedirect("/ProjetEni/encherir/" + num);
				return;
			}

			if (enchere.getMontant_enchere() <= utilisateur.getCredit()) {
				request.setAttribute("erreur", "Vous n'avez pas assez de crédit!");
				response.sendRedirect("/ProjetEni/encherir/" + num);
				return;
			}

			try {
				enchere.setNo_utilisateur(num);
				enchere.setMontant_enchere(montant_int);
				encheresDAO.update(enchere);
			} catch (DalException e) {
				request.setAttribute("erreur", "Erreur lors de la mise à jour de l'enchère");
				e.printStackTrace();
			}

			response.sendRedirect("/ProjetEni/encherir/" + num);
			return;

		}

	}

}