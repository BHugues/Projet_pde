package business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import launcher.Launcher;

public class TestGestionUtilisateursImpl {

	private Launcher launcher;
	private GestionUtilisateursImpl gestionUtilisateurs;

	@Before
	public void setUp() throws Exception {
		launcher = new Launcher();
		gestionUtilisateurs = new GestionUtilisateursImpl(launcher);
		System.out.println("Debut du test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Fin du test");
	}

	@Test
	public void testConnecterUtilisateur1() {
		assertTrue(
				"Login correct avec password correct aurait du être accepté",
				gestionUtilisateurs.connecterUtilisateur("chris@gmail.com",
						"password123"));
	}

	@Test
	public void testConnecterUtilisateur2() {
		assertFalse("Login correct mais password faux aurait du être refusé",
				gestionUtilisateurs.connecterUtilisateur("chris@gmail.com",
						"mauvais password"));
	}

	@Test
	public void testConnecterUtilisateur3() {
		assertFalse("Login correct mais password null aurait du être refusé",
				gestionUtilisateurs.connecterUtilisateur("chris@gmail.com",
						null));
	}

	@Test
	public void testConnecterUtilisateur4() {
		assertTrue(
				"Test bidon pour montrer un test qui echoue",
				gestionUtilisateurs.connecterUtilisateur("bob@gmail.com",
						"password"));
	}

//	@Test(expected = IndexOutOfBoundsException.class)
//	public void outOfBounds() {
//		new ArrayList<Object>().get(1);
//	}
	
	@Test(timeout=30)
	public void testConnecterUtilisateur5() {
		assertTrue(
				"Login correct avec password correct aurait du être accepté",
				gestionUtilisateurs.connecterUtilisateur("chris@gmail.com",
						"password123"));
	}
	
}
