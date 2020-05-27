package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme{

	public VueLigne(Ligne ligne) {
		
		super(ligne);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		
		Color couleurSauvegardee = g2d.getColor();
		g2d.setColor(getForme().getCouleur());
		
		
		int x1 = (int)Math.round(getForme().getPosition().getAbscisse());
		int y1 = (int)Math.round(getForme().getPosition().getOrdonnee());
		int x2 = (int)Math.round(getForme().getPosition().getAbscisse() + getForme().getLargeur());
		int y2 = (int)Math.round(getForme().getPosition().getOrdonnee() + getForme().getHauteur());
		
		
		g2d.drawLine(x1, y1, x2, y2);
		g2d.setColor(couleurSauvegardee);
		
	}

	
	
	
	
}
