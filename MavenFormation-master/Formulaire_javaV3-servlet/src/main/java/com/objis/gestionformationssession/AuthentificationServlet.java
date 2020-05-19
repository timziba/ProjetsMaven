/**
 * Classe authentification servlet du projet Formulaire Java JSP Servlet
 * 
 * @author Master 1 ED2O
 * @version 0.0.1
 */
package com.objis.gestionformationssession.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objis.gestionformationssession.dao.UserDAO;
import com.objis.gestionformationssession.metier.User;
import com.objis.gestionformationssession.service.ServiceGestion;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher;
		ServiceGestion auth = new ServiceGestion();
		
		if(auth.authentificate(login, password)) {
			User user = auth.getUser(login);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", user);
			dispatcher = request.getRequestDispatcher("accueil.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("login.html");
		}
		
		dispatcher.forward(request, response);
	}
}
