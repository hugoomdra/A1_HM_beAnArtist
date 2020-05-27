package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionner extends AbstractAction{

	public static final String NOM_ACTION = "Sélectionner";
	
	private PanneauDessin lePanneauDessin;

	public ActionSelectionner(PanneauDessin unPanneauDessin) {
		super(NOM_ACTION);
		setLePanneauDessin(unPanneauDessin);
	}
		
	public PanneauDessin getLePanneauDessin() {
		return lePanneauDessin;
	}
	
	public void setLePanneauDessin(PanneauDessin lePanneauDessin) {
		this.lePanneauDessin = lePanneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		getLePanneauDessin().associerOutil(new OutilSelectionner());
	}

	
	
}
