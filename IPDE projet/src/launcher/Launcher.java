package launcher;

import ihm.ConnexionConsole;
import ihm.ConnexionSwing;
import business.GestionUtilisateurs;
import business.GestionUtilisateursImpl;
import db.DBOperations;
import db.DBOperationsMock;
import db.DBOperationsSQLite;

public class Launcher {

	private ConnexionConsole connexionConsole;
	private ConnexionSwing connexionSwing;
	private DBOperations dBOperations;
	private GestionUtilisateurs gestionUtilisateurs;

	public Launcher() {
		// CHOIX DB MOCK/SQLITE
		// dBOperations=new DBOperationsMock();
		dBOperations = new DBOperationsSQLite();

		gestionUtilisateurs = new GestionUtilisateursImpl(this);

		// CHOIX INTERFACE SWING/CONSOLE
		connexionSwing = new ConnexionSwing(this);
		// connexionConsole=new ConnexionConsole(this);

	}

	public static void main(String[] args) {
		Launcher launch = new Launcher();
	}

	public ConnexionConsole getConnexionConsole() {
		return connexionConsole;
	}

	public ConnexionSwing getConnexionSwing() {
		return connexionSwing;
	}

	public GestionUtilisateurs getGestionUtilisateurs() {
		return gestionUtilisateurs;
	}

	public DBOperations getDBOperations() {
		return dBOperations;
	}

}
