package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacer extends AbstractAction{
	
	public static final String NOM_ACTION = "Tout effacer";
	
	private PanneauDessin lePanneauDessin;

	public ActionEffacer(PanneauDessin unPanneauDessin) {
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
		
		int choix = JOptionPane.showConfirmDialog(getLePanneauDessin(), "Êtes-vous sûr de tous vouloir effacer", NOM_ACTION, JOptionPane.YES_NO_OPTION);
		
		if(choix == 0) {
			lePanneauDessin.getVueFormes().clear();
			lePanneauDessin.repaint();
			System.out.println("efface tous");
		}
		
		
		
		
	}
	
}
