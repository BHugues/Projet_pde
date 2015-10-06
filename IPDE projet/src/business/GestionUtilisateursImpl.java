package business;

import db.DBOperations;
import db.DBOperationsSQLite;
import launcher.Launcher;
import model.Utilisateur;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import org.apache.commons.lang.NotImplementedException;


//test SVN

public class GestionUtilisateursImpl {

	private Launcher launcher;
	
	public GestionUtilisateursImpl(Launcher l){
		this.launcher=l;
	}
	
	public boolean connecterUtilisateur(String login, String password) {
		
		DBOperations dBOperations=launcher.getDBOperations();
		Utilisateur utilisateur=dBOperations.getUtilisateur(login, password);
		if (utilisateur==null){
			System.out.println("Impossible de connecter l'utilisateur. Login+password incorrects.");
			return false;
		}
		System.out.println("L'utilisateur "+login+"/"+password+ " est maintenant connecté.");
		return true;
	}


	public boolean AjouterClient(String nom, String mail, String password) {
		if ((nom == null) || (mail == null) || (mail == null)) {
			return false;
		}
		if ((nom == "") || (mail == "") || (password == "")) {
			return false;
		}

		Utilisateur nouveauUtilisateur = new Utilisateur();
		nouveauUtilisateur.setNom(nom);
		nouveauUtilisateur.setMail(mail);
		nouveauUtilisateur.setPassword(password);

		boolean resultatAjoutUtilisateurEnDB = launcher.getDBOperations().createUtilisateur(nouveauUtilisateur);
		return resultatAjoutUtilisateurEnDB;
	}
	

}
