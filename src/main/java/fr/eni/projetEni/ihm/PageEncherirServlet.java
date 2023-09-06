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
	        System.out.println(enchere);
	        request.setAttribute("enchere", enchere); 
	    } else {
	        // Gérez ici le cas où l'ID est null si nécessaire
	    }
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageEncherir.jsp");
	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utilisateur utilisateur = new Utilisateur();
		System.out.println(session.getAttribute("utilisateurConnecte").toString());

	}

}