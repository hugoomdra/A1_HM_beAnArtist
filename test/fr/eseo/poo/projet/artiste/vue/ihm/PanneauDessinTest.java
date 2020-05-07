package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauDessinTest {
	
	public PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();
	}

	private void testConstructeurParDefaut() {
		JFrame fenetre = new JFrame();
		fenetre.add(new PanneauDessin());
		fenetre.setLocationRelativeTo(null);
		fenetre.setTitle("Etre un Artiste");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
		
	}
	
	private void testConstructeur() {
		JFrame fenetre = new JFrame();
		fenetre.add(new PanneauDessin(600, 400, Color.BLUE));
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
				new PanneauDessinTest();
				
			}
		});

	}

}
