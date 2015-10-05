package db;

import java.util.LinkedList;

import model.Utilisateur;

public interface DBOperations {
	
	public abstract LinkedList<Utilisateur> getUtilisateurs();
	public abstract boolean createUtilisateur(Utilisateur newUtilisateur);
	public abstract Utilisateur getUtilisateur (String log, String pwd);
	
}
