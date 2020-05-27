package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	public VueLigneTest() {
		testAffiche();
		
	}

	private void testAffiche() {
		
		Ligne ligne1 = new Ligne(new Coordonnees(100, 100), 100, 100);
		Ligne ligne2 = new Ligne(new Coordonnees(400, 200), -100, 200);
		Ligne ligne3 = new Ligne(new Coordonnees(67, 90), 150, -100);
		Ligne ligne4 = new Ligne(new Coordonnees(150, 100), 100, 100);
		
		PanneauDessin panneau = new PanneauDessin();
		panneau.ajouterVueForme(new VueLigne(ligne1));
		panneau.ajouterVueForme(new VueLigne(ligne2));
		panneau.ajouterVueForme(new VueLigne(ligne3));
		panneau.ajouterVueForme(new VueLigne(ligne4));
	
		
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
				new VueLigneTest();
				
			}
		});

	}
	
}
