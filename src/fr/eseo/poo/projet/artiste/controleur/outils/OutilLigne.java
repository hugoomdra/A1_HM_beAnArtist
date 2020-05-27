package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme{

	@Override
	protected VueForme creerVueForme() {
		
		
		double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
		double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
		
		Ligne ligne = new Ligne(getDebut(), largeur, hauteur);
		ligne.setCouleur(getPanneauDessin().getCouleurCourante());
		return new VueLigne(ligne);
		
	}

	
	
}
