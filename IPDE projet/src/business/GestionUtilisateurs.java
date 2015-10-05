package business;

public interface GestionUtilisateurs {

	public abstract boolean ajouterUtilisateur();

	public abstract boolean connecterUtilisateur(String login, String password);

}