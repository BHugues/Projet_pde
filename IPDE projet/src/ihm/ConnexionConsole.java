package ihm;

import java.util.Scanner;

import launcher.Launcher;

public class ConnexionConsole {

	static private Scanner scanner = new Scanner(System.in);

	private Launcher launcher;

	public ConnexionConsole(Launcher l) {
		this.launcher = l;
		menuGeneral();
	}

	public void menuGeneral() {
		System.out.println("Menu Application Allocine");
		System.out.println("1. Connexion");
		// System.out.println("2. Inscription");
		System.out.print("Votre choix : ");
		String choix = scanner.nextLine();

		if (choix.equals("1")) {
			connexion();
		} else {
			System.out.println("L'entrée semble erronnée. Fin du programme.");
		}

	}

	public void connexion() {
		System.out.print("Login (=email) : ");
		String login = scanner.nextLine();
		System.out.print("Password : ");
		String password = scanner.nextLine();
		System.out.println("Log:" + login + ", pwd:" + password);
		boolean userConnectedlauncher = launcher.getGestionUtilisateurs()
				.connecterUtilisateur(login, password);
	}

}
