package fr.eni.projetEni.ihm;

import java.io.IOException;

import fr.eni.projetEni.bll.ManagerException;
import fr.eni.projetEni.bll.UtilisateurManager;
import fr.eni.projetEni.bll.UtilisateurManagerSing;
import fr.eni.projetEni.bo.Utilisateurs;
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
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();
	
	/**
	 * @throws jakarta.servlet.ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, jakarta.servlet.ServletException {
		request.getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
	}

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		System.out.println(login+" "+ password);

		
		Utilisateurs utilisateur= new Utilisateurs();
		try {
			utilisateur = uManager.check(login,password);
			System.out.println(String.valueOf(utilisateur));
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO: uManager.check
		HttpSession session = request.getSession();

		System.out.println(String.valueOf(utilisateur));
		if(utilisateur==null) {
			request.setAttribute("message", "utilisateur inconnnu");
			request.getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "c'est ok ");
			request.getSession().setAttribute("utilisateur", utilisateur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageListEncheresConnecte.jsp");
			rd.forward(request, response);
		}

	}
}