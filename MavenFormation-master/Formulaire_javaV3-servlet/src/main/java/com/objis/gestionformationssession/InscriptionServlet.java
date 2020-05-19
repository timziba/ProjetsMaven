/**
 * Classe inscription servlet du projet Formulaire Java JSP Servlet
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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();

		userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		RequestDispatcher dispatcher;
		ServiceGestion serviceGestion = new ServiceGestion();
		
		serviceGestion.create(nom, prenom, email, mdp);
		
		User user = new User(email, mdp, email, mdp);
		
		HttpSession session = request.getSession();
		session.setAttribute("utilisateur", user);
		dispatcher = request.getRequestDispatcher("accueil.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
