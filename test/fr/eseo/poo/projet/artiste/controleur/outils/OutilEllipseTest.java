package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEllipseTest {
	
	public OutilEllipseTest() {
		test();
		
	}
	
	private void test() {
		JFrame fenetre = new JFrame();
		
		PanneauDessin panneauDessin = new PanneauDessin();
		OutilEllipse outil = new OutilEllipse();
		panneauDessin.associerOutil(outil);
		

		fenetre.add(panneauDessin);
		fenetre.setLocationRelativeTo(null);
		fenetre.setTitle("Blues du Businessman");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new OutilEllipseTest();
			
			}
		});

	}
}
