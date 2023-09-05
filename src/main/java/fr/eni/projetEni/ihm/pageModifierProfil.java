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
@WebServlet("/modifie_mon_profil")
public class pageModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();

	/**
	 * @throws jakarta.servlet.ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, jakarta.servlet.ServletException {

		request.getRequestDispatcher("/WEB-INF/pageModifierProfil.jsp").forward(request, response);
	}

	/**
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Utilisateur utilisateur = new Utilisateur();

		HttpSession session = request.getSession();
		Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateurConnecte");

		if (request.getParameter("act").equals("modifier")) {
			utilisateur.setNo_utilisateur(utilisateurSession.getNo_utilisateur());
			utilisateur.setCredit(utilisateurSession.getCredit());
			utilisateur.setAdministrateur(utilisateurSession.getAdministrateur());
			utilisateur.setMot_de_passe(utilisateurSession.getMot_de_passe());
			utilisateur.setPseudo(utilisateurSession.getPseudo());
			utilisateur.setLstArticles(utilisateurSession.getLstArticles());
			utilisateur.setLstEncheres(utilisateurSession.getLstEncheres());
			utilisateur.setNom((String) request.getParameter("nom"));
			utilisateur.setPrenom((String) request.getParameter("prenom"));
			utilisateur.setEmail((String) request.getParameter("email"));
			utilisateur.setTelephone((String) request.getParameter("telephone"));
			utilisateur.setRue((String) request.getParameter("rue"));
			utilisateur.setCode_postal((String) request.getParameter("codePostal"));
			utilisateur.setVille((String) request.getParameter("ville"));
			utilisateur.setPrenom((String) request.getParameter("prenom"));

			try {
				System.out.println("user " + utilisateur);
				session.setAttribute("utilisateurConnecte", utilisateur);
				uManager.majUtilisateur(utilisateur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageMonProfil.jsp");
				rd.forward(request, response);
			} catch (ManagerException e) {
				e.printStackTrace();
			}
		} else {
			try {
				uManager.supprimerUtilisateur(utilisateurSession.getNo_utilisateur());
				session.invalidate();
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp");
				rd.forward(request, response);
			} catch (ManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}
}
