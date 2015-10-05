package business;

import db.DBOperations;
import launcher.Launcher;
import model.Utilisateur;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import org.apache.commons.lang.NotImplementedException;


//test SVN

public class GestionUtilisateursImpl implements GestionUtilisateurs {

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


	public boolean ajouterUtilisateur() {
		//throw new NotImplementedException();
		return false;
	}

}
