package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import model.Utilisateur;

/**
 * Classe qui g�re toutes les op�rations de lecture et �criture en base de donn�es.
 * Elle ne fait que �a, pas d'autres traitements.
 * C'est la couche fonctionnalit�s qui lui donne les ordres.
 */

public class DBOperationsSQLite implements DBOperations {

	private static String dbUrl="jdbc:sqlite:src\\db_projet_pde.sqlite";
	
	/**
	 * Le constructeur pr�pare la base de donn�es avec un driver JDBC :
	 * "Java Data Base Connector".
	 */
	public DBOperationsSQLite() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/**
	 * Obtention de tous les clients inscrits dans la base de donn�es.
	 * Pour le fonctionnement en DB, voir les commentaires de la m�thode "dbObtenirUnClient()"
	 * @return
	 */

	public LinkedList<Utilisateur> getUtilisateurs() {

		LinkedList<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();
		Connection c = null;
		Statement stmt = null;

		try {
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateur;");

			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				/*
				System.out.println("ID = " + id);
				System.out.println("NOM = " + nom);
				System.out.println("MAIL = " + mail);
				System.out.println("PASSWORD = " + password);
				*/
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setDbId(id);
				utilisateur.setNom(nom);
				utilisateur.setMail(mail);
				utilisateur.setPassword(password);
				utilisateurs.add(utilisateur);
			}
			
			rs.close();
			stmt.close();
			c.close();
			return (utilisateurs);
	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

	}
	
	/**
	 * Enregistre le client fourni en param�tre dans la DB
	 * @param nouveauClient Un objet Client avec les informations duquel on va cr�er une nouvelle ligne en DB
	 * @return True si la m�thode a eu lieu sans erreur, false sinon.
	 */

	public boolean createUtilisateur(Utilisateur newUtilisateur) {
		Connection connectionDB = null;
		PreparedStatement requeteSQLPreparee = null;
		
		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);
						
			requeteSQLPreparee = connectionDB.prepareStatement("INSERT INTO Clients(nom, mail, password) VALUES(?, ?, ?);");
			requeteSQLPreparee.setString(1, newUtilisateur.getNom());
			requeteSQLPreparee.setString(2, newUtilisateur.getMail());
			requeteSQLPreparee.setString(3, newUtilisateur.getPassword());
						
			// !!!
			// ATTENTION, pour un INSERT sql, on n'utilise pas la m�thode executeQuery, mais cette m�thode ci (executeUpdate()) :
			requeteSQLPreparee.executeUpdate();
						
			requeteSQLPreparee.close();
			connectionDB.close();
			
			return true;
	
		} catch (Exception e) {
			System.out.println("ERREUR OPERATION DB");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Cette m�thode va chercher un client en DB sur base de son pr�nom et de son nom.
	 * @param prenomRecherche Le pr�nom du client recherch� en DB.
	 * @param nomRecherche Le nom du client recherch� en DB.
	 * @return Le client recherch� si on l'a trouv�, ou null si il n'est pas en DB.
	 */

	public Utilisateur getUtilisateur(String log, String pwd) {
		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Utilisateur utilisateur = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.prepareStatement("SELECT * FROM utilisateur WHERE mail=? AND password=?");
			stmt.setString(1, log);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				utilisateur = new Utilisateur();
				utilisateur.setDbId(id);
				utilisateur.setNom(nom);
				utilisateur.setMail(mail);
				utilisateur.setPassword(password);
			}
			return utilisateur;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	}

}
