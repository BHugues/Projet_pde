package model;

/**
 * Cette classe sert a stocker et echanger les donnees d'un utilisateur. <b>
 * Aucune methode autre que des getters et setter ne doit s'y trouver.</b>
 * 
 * @author Christophe Lemaigre
 * @version 1.0
 * 
 */
public class Utilisateur {

	private int dbId;
	private String nom;
	private String mail;
	private String password;

	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	/**
	 * Simple getter pour obtenir le nom de l'objet courant de type Utilisateur.
	 * <b> Inutile de faire une javadoc pour cela, en général. </b>
	 * 
	 * @return Le nom de l'utilisateur.
	 */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object other) {
		if (other instanceof Utilisateur) {
			Utilisateur autreUtilisateur = (Utilisateur) other;
			return (autreUtilisateur.nom.equals(this.nom));
		} else
			return false;
	}

}
