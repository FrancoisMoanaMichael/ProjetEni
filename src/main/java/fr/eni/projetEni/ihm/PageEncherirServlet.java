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

		if (session.getAttribute("utilisateurConnecte") == null) {
			//session.invalidate();
			response.sendRedirect("/ProjetEni/");
			return;
		} else {
			
			Utilisateur utilisateur = new Utilisateur();
			utilisateur = (Utilisateur) session.getAttribute("utilisateurConnecte");
			
			String montant = request.getParameter("montant");
			String id_enchere = request.getParameter("id_enchere");

			int num = Integer.parseInt(id_enchere);
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
			

			//System.out.println(utilisateur.getNo_utilisateur());
//			try {
//				encheresDAO.update(article, num, montant_int);
//			} catch (DalException e) {
//				e.printStackTrace();
//			}

		}

	}

}