package fr.eni.projetEni.ihm;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/EncheresServlet")
public class EncheresServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @throws jakarta.servlet.ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, jakarta.servlet.ServletException {
		request.getRequestDispatcher("/WEB-INF/encheresConnection.jsp").forward(request, response);
	}

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/encheresConnection.jsp").forward(request, response);
		
	}
}
