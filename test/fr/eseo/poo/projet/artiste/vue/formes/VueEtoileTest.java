package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEtoileTest {
	public VueEtoileTest() {
		testAffiche();
	}
	
	
	private void testAffiche() {
		
		Etoile etoile1 = new Etoile(new Coordonnees(100, 100), 120);
		Etoile etoile2 = new Etoile(new Coordonnees(200, 200), 40, 4, 0, 0.75);
		etoile2.setCouleur(Color.red);

		PanneauDessin panneau = new PanneauDessin();
		panneau.ajouterVueForme(new VueEtoile(etoile1));
		panneau.ajouterVueForme(new VueEtoile(etoile2));
		
	
		
		JFrame fenetre = new JFrame();
		fenetre.add(panneau);
		fenetre.setLocationRelativeTo(null);
		fenetre.setTitle("Etre un Artiste");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VueEtoileTest();
				
			}
		});

	}
}
