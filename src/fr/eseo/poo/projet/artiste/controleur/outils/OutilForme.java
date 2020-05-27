package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil{
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
				
		if(e.getClickCount() == 2) {
	
			double largeur = getDebut().getAbscisse() + Forme.LARGEUR_PAR_DEFAUT;
			double hauteur = getDebut().getOrdonnee() + Forme.HAUTEUR_PAR_DEFAUT;
			Coordonnees c2 = new Coordonnees(largeur, hauteur);
			setFin(c2);
			getPanneauDessin().ajouterVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if(getDebut().getAbscisse() != getFin().getAbscisse() || getDebut().getOrdonnee() != getFin().getOrdonnee()) {
			super.mouseReleased(e);
			getPanneauDessin().ajouterVueForme(creerVueForme());
			getPanneauDessin().repaint();
		
			
		}
	}

	abstract protected VueForme creerVueForme();

}
