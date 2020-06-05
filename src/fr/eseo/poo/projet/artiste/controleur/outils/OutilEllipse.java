package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme{

	@Override
	protected VueForme creerVueForme() {
		double largeur = Math.abs(getFin().getAbscisse() - getDebut().getAbscisse());
		double hauteur = Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee());
		
		double minX = Math.min(getDebut().getAbscisse(), getFin().getAbscisse());
		double minY = Math.min(getDebut().getOrdonnee(), getFin().getOrdonnee());
		
		Coordonnees coord = new Coordonnees(minX, minY);
		
		
		Ellipse ellipse = new Ellipse(coord, largeur, hauteur);
		ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(getPanneauDessin().getModeRemplissage());
		return new VueEllipse(ellipse);
	}

}