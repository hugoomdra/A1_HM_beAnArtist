package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends AbstractAction{

	public static final String NOM_ACTION = "Choisir Couleur";

	
	private PanneauDessin panneauDessin;
	private Color couleur;
	
	

	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.couleur = Forme.COULEUR_PAR_DEFAUT;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = JColorChooser.showDialog(getPanneauDessin(), ActionChoisirCouleur.NOM_ACTION, getCouleur());
		
		if(color != null) {
			System.out.println("couleur");
			getPanneauDessin().setCouleurCourante(color);
		}
	}


	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}


	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}


	public Color getCouleur() {
		return couleur;
	}


	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	


	

	
}
