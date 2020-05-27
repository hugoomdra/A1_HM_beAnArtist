package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {

	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
	}

	@Override
	protected VueForme creerVueForme() {
		double largeur = Math.abs(getFin().getAbscisse() - getDebut().getAbscisse());
		double hauteur = Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee());
		
		double cote = largeur >= hauteur ? largeur : hauteur;
		double x = 0;
		double y = 0;
		
		
		if(getDebut().getAbscisse() > getFin().getAbscisse() && getDebut().getOrdonnee() > getFin().getOrdonnee()){
			
			x = getDebut().getAbscisse() - cote;
            y = getDebut().getOrdonnee() - cote;
			
		}
		else if(getDebut().getAbscisse() > getFin().getAbscisse() &&
                getDebut().getOrdonnee() < getFin().getOrdonnee()) {
			x = getDebut().getAbscisse() - cote;
            y = getDebut().getOrdonnee();
		}
		else if (getDebut().getAbscisse() <= getFin().getAbscisse() && getDebut().getOrdonnee() <= getFin().getOrdonnee()) {
			x = getDebut().getAbscisse();
			y = getDebut().getOrdonnee();
		
		}else {
			x = getDebut().getAbscisse();
            y = getDebut().getOrdonnee() - cote;
		}
	
		
		Coordonnees coord = new Coordonnees(x, y);
		
		Cercle cercle = new Cercle(coord, cote);
		cercle.setCouleur(getPanneauDessin().getCouleurCourante());
		return new VueCercle(cercle);
	}


	
	
}
