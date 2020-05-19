/**
 * La classse Utilisateur du projet Formulaire Java JSP Servlet
 */
package com.objis.gestionformationssession.metier;

public class User {

	private String login, password, name, first_name;

	public User(String login, String password, String name, String first_name) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.first_name = first_name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
}
