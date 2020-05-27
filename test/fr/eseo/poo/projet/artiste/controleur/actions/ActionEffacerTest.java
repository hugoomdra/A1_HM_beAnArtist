package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigneTest;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacerTest {

	public ActionEffacerTest() {
		test();
		
	}
	
	private void test() {
		JFrame fenetre = new JFrame();
		
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils barreOutils = new PanneauBarreOutils(panneauDessin);
		OutilLigne outilLigne = new OutilLigne();
		panneauDessin.associerOutil(outilLigne);
	
		fenetre.add(panneauDessin, BorderLayout.WEST);
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setTitle("Blues du Businessman");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.add(barreOutils, BorderLayout.EAST);
		fenetre.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ActionEffacerTest();
				
			}
		});

	}
	
	
	
	
	
	
}
