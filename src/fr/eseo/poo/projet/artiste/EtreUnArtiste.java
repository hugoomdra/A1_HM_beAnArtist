package fr.eseo.poo.projet.artiste;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {

	 public static void main(String[] args) {
	        JFrame mainWindow = new JFrame();
	        mainWindow.setTitle("Etre un artiste");
	        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        PanneauDessin panneauDessin = new PanneauDessin();
	        PanneauBarreOutils outilsPanneauDessin = new PanneauBarreOutils(panneauDessin);

	        mainWindow.add(panneauDessin, BorderLayout.WEST);
	        mainWindow.add(outilsPanneauDessin, BorderLayout.EAST);

	        mainWindow.pack();
	        mainWindow.setVisible(true);
	    }

	
	
}
