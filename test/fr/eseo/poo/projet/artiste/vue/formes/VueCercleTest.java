package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {

	
	public VueCercleTest() {
		testAffiche();
	}
	
	
	private void testAffiche() {
		
		Cercle cercle1 = new Cercle(new Coordonnees(100, 100), 100);
		Cercle cercle2 = new Cercle(new Coordonnees(300, 150), 90);
		Cercle cerlce3 = new Cercle(new Coordonnees(200, 100), 150);
		Cercle cerlce4 = new Cercle(new Coordonnees(300, 100), 40);
		
		PanneauDessin panneau = new PanneauDessin();
		panneau.ajouterVueForme(new VueEllipse(cercle1));
		panneau.ajouterVueForme(new VueEllipse(cercle2));
		panneau.ajouterVueForme(new VueEllipse(cerlce3));
		panneau.ajouterVueForme(new VueEllipse(cerlce4));
		
	
		
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
				new VueCercleTest();
				
			}
		});

	}
	
	
	
	
}
