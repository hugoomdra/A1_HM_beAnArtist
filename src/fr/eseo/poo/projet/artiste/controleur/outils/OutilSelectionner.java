package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilSelectionner extends Outil{

	private Forme formeSelectionnee;

	public Forme getFormeSelectionnee() {
		return formeSelectionnee;
	}

	public void setFormeSelectionnee(Forme formeSelectionnee) {
		this.formeSelectionnee = formeSelectionnee;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		super.mouseClicked(e);
		
		Coordonnees coord = new Coordonnees(e.getX(), e.getY());
		
		
		for (int i = getPanneauDessin().getVueFormes().size() - 1; i >= 0 ; i--) {
		    VueForme item = getPanneauDessin().getVueFormes().get(i);
		    
		    if(item.getForme().contient(coord)) {
				setFormeSelectionnee(item.getForme());
				JOptionPane.showMessageDialog(this.getPanneauDessin(), getFormeSelectionnee().toString(),
						ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		    
		    
		}
		
			
		
	}
	
	
	
	
	
	
}
