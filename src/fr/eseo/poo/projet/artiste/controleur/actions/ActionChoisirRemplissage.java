package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissage extends AbstractAction{
	
	public static final String NOM_ACTION = "Remplissage";
	
	private final PanneauDessin panneauDessin;
	
	public ActionChoisirRemplissage(PanneauDessin panneauDessin) {
		super();
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panneauDessin.setModeRemplissage(!panneauDessin.getModeRemplissage());
		System.out.println(!panneauDessin.getModeRemplissage());
		
	}
	
	

}
