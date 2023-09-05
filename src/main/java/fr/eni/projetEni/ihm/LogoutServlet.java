package fr.eni.projetEni.ihm;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deconnexion")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, jakarta.servlet.ServletException {
		HttpSession session = request.getSession(false); // Ne crée pas de nouvelle session si elle n'existe pas

		if (session != null) {
			session.invalidate(); // Invalide la session actuelle
		}
		request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession(false); // Ne crée pas de nouvelle session si elle n'existe pas
//
//		if (session != null) {
//			session.invalidate(); // Invalide la session actuelle
//		}
//		request.getRequestDispatcher("/WEB-INF/pagesAccueilNonConnecte.jsp").forward(request, response);
	}
}
