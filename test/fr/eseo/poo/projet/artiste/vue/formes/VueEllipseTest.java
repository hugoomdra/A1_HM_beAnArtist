package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {
	
	public VueEllipseTest() {
		testAffiche();
	}
	
	
	private void testAffiche() {
		
		Ellipse ellipse1 = new Ellipse(new Coordonnees(100, 100), 100, 80);
		Ellipse ellipse2 = new Ellipse(new Coordonnees(300, 150), 100, 80);
		Ellipse ellipse3 = new Ellipse(new Coordonnees(200, 100), 100, 80);
		Ellipse ellipse4 = new Ellipse(new Coordonnees(300, 100), 100, 80);
		
		PanneauDessin panneau = new PanneauDessin();
		panneau.ajouterVueForme(new VueEllipse(ellipse1));
		panneau.ajouterVueForme(new VueEllipse(ellipse2));
		panneau.ajouterVueForme(new VueEllipse(ellipse3));
		panneau.ajouterVueForme(new VueEllipse(ellipse4));
		
	
		
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
				new VueEllipseTest();
				
			}
		});

	}

}
