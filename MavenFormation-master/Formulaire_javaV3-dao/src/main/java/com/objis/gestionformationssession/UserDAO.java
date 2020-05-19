/**
 * Classe  utilisateur dao  du projet Formulaire Java JSP Servlet
 * 
 * @author Master 1 ED2O
 * @version 0.0.1
 */
package com.objis.gestionformationssession.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.objis.gestionformationssession.metier.User;

public class UserDAO {

	private String url = "jdbc:mysql://localhost/gestionformations?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String sql_login = "root";
	private String sql_password = "";
	
	
	public void createUser(String nom, String prenom, String mail, String mdp) {
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "INSERT INTO user (nom, prenom, mail, mdp) VALUES ('"+ nom +"', '"+ prenom +"', '"+ mail +"', '"+ mdp +"')";
			
			st.executeUpdate(sql);
			
			cn.close();
			st.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getUser(String login, String mdp) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "SELECT * FROM user WHERE mail = '"+ login +"' AND mdp = '"+ mdp +"'";
			
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return true;
			}
			cn.close();
			st.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUser(String login) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "SELECT * FROM user WHERE mail = '"+ login +"'";
			
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return new User(rs.getString("mail"), rs.getString("mdp"), rs.getString("nom"), rs.getString("prenom"));
			}
			cn.close();
			st.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<User> getAllUser() {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "SELECT * FROM user";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				users.add(new User(rs.getString("mail"), rs.getString("mdp"), rs.getString("nom"), rs.getString("prenom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public void deleteUser(String mail) {
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "DELETE FROM user WHERE mail = '"+ mail +"'";
			
			st.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateUser(String last_mail, String name, String first_name, String new_mail, String password) {
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();
			
			String sql = "UPDATE user(nom, prenom, mail, mdp)  VALUES('"+ name +"', '"+ first_name +"', '"+ new_mail +"', '"+ password +"') WHERE mail = '"+ last_mail +"'";
			
			st.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
