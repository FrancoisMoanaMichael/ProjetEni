package fr.eni.projetEni.ihm;

import java.io.IOException;

import fr.eni.projetEni.bll.ManagerException;
import fr.eni.projetEni.bll.UtilisateurManager;
import fr.eni.projetEni.bll.UtilisateurManagerSing;
import fr.eni.projetEni.bo.Utilisateur;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/creeUnCompte")
public class CreeComptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager uManager = UtilisateurManagerSing.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageCreeCompte.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur nvUtilisateur = new Utilisateur();

		String pseudo = String.valueOf(request.getParameter("pseudo"));
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		String email = (String) request.getParameter("email");
		String telephone = (String) request.getParameter("telephone");
		String rue = (String) request.getParameter("rue");
		String codePostal = (String) request.getParameter("codePostal");
		String ville = (String) request.getParameter("ville");
		String motDePasse = (String) request.getParameter("motDePasse");
		String confirmation = (String) request.getParameter("confirmation");

		System.out.println("teste mdp :" + motDePasse);

		if (pseudo != "" || prenom != "" || prenom != "" || email != "" || telephone != "" || rue != ""
				|| codePostal != "" || ville != "" || motDePasse != "" || confirmation != "") {
			nvUtilisateur.setPseudo(pseudo);
			nvUtilisateur.setNom(nom);
			nvUtilisateur.setPrenom(prenom);
			nvUtilisateur.setEmail(email);
			nvUtilisateur.setTelephone(telephone);
			nvUtilisateur.setRue(rue);
			nvUtilisateur.setCode_postal(codePostal);
			nvUtilisateur.setVille(ville);
			nvUtilisateur.setCredit(0);
			nvUtilisateur.setAdministrateur(false);

			if (motDePasse.equals(confirmation)) {
				nvUtilisateur.setMot_de_passe(motDePasse);
				try {
					uManager.addUtilisateur(nvUtilisateur);
					Utilisateur utilisateurAjoute = uManager.getAllUtilisateurs().get(1);
					System.out.println(String.valueOf(utilisateurAjoute));
				} catch (ManagerException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
			
			}else {
//				TODO garder les champs remlis au rechargement si erreur
//				request.setAttribute("pseudo", pseudo);
//				request.setAttribute("nom", nom);
//				request.setAttribute("prenom", prenom);
//				request.setAttribute("email", email);
//				request.setAttribute("telephone", telephone);
//				request.setAttribute("rue", rue);
//				request.setAttribute("codePostal", codePostal);
//				request.setAttribute("ville", ville);
				request.setAttribute("message", "Les mots de passe ne sont pas identiques.");
			}
		} else {
			request.setAttribute("message", "Ne pas laisser de champs vides");
		}
		request.getRequestDispatcher("/WEB-INF/pageCreeCompte.jsp").forward(request, response);

	}

}