package fr.eni.projetEni.ihm;

import java.io.IOException;

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
			Enchere enchere = null;
			try {
				enchere = encheresDAO.findEnchereById(num);
			} catch (DalException e) {
				e.printStackTrace();
			}
			

			if (enchere.getMontant_enchere() >= montant_int) {
				// TODO
				return;
			}
			
			//System.out.println(utilisateur.getNo_utilisateur());
			try {
				encheresDAO.update(enchere, num, montant_int);
			} catch (DalException e) {
				e.printStackTrace();
			}

		}

	}

}