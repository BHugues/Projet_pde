package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import launcher.Launcher;

public class ConnexionSwing extends JFrame implements ActionListener {

	private JButton connectJb;
	private JButton resetJb;
	private JTextField mailTf;
	private JPasswordField passwordTf;

	private Launcher launcher;

	public ConnexionSwing(Launcher l) {
		super("Ecran de connexion");

		this.launcher = l;

		setSize(600, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel logJp = new JPanel();
		logJp.setLayout(new GridLayout(4, 2));

		try {
			BufferedImage picture = ImageIO.read(new File("allocine.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(picture));
			logJp.add(picLabel);
			logJp.add(new JLabel());
		} catch (IOException ioe) {
			System.out.println("Erreur au chargement de l'image.");
			System.out.println("Le repertoire courant est le suivant : "
					+ System.getProperty("user.dir"));
		}

		JLabel mailJl = new JLabel("Login (user mail) :");
		JLabel passwordJl = new JLabel("Password :");
		mailTf = new JTextField();
		passwordTf = new JPasswordField();

		logJp.add(mailJl);
		logJp.add(mailTf);
		logJp.add(passwordJl);
		logJp.add(passwordTf);

		connectJb = new JButton("Connect");
		connectJb.addActionListener(this);
		resetJb = new JButton("Reset");
		resetJb.addActionListener(this);

		JPanel connectResetJp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		connectResetJp.add(connectJb);
		connectResetJp.add(resetJb);

		logJp.add(new JPanel()); // Jpanel vide servant de placeHolder.
		logJp.add(connectResetJp);
		this.add(logJp);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		JButton srcButton = (JButton) ae.getSource();

		if (srcButton == connectJb) {
			launchConnexionUseCase(mailTf.getText(),
					new String(passwordTf.getPassword()));
			return;
		}

		if (srcButton == resetJb) {
			mailTf.setText("");
			passwordTf.setText("");
			return;
		}

	}

	public void launchConnexionUseCase(String log, String password) {
		boolean userConnected = launcher.getGestionUtilisateurs()
				.connecterUtilisateur(log, password);
	}

}
