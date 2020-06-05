package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction{

	public static final String NOM_ACTION_LIGNE = "Outil Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Outil Ellipse";
	public static final String NOM_ACTION_CERCLE = "Outil Cercle";
	public static final String NOM_ACTION_ETOILE = "Outil Etoile";
	
	private PanneauDessin panneauDessin;
	private PanneauBarreOutils outil;
	private String action;
	
	

	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils outil, String action) {
		super(action);
		this.panneauDessin = panneauDessin;
		this.outil = outil;
		this.action = action;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 switch (this.action) {
         case NOM_ACTION_LIGNE:
    
             getPanneauDessin().associerOutil(new OutilLigne());
             break;
         case NOM_ACTION_ELLIPSE:
             getPanneauDessin().associerOutil(new OutilEllipse());
             break;
         case NOM_ACTION_CERCLE:
             getPanneauDessin().associerOutil(new OutilCercle());
             break;
         case NOM_ACTION_ETOILE:
             getPanneauDessin().associerOutil(new OutilEtoile(outil));
             break;
 
         default:
             throw new IllegalArgumentException();
     }

		 
		
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}

	public PanneauBarreOutils getOutil() {
		return outil;
	}

	public void setOutil(PanneauBarreOutils outil) {
		this.outil = outil;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	
	
	
}
