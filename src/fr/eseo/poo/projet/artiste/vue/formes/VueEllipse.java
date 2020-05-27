package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme{

	
	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	
	}

	@Override
	public void affiche(Graphics2D g2d) {
		double x1 = getForme().getPosition().getAbscisse();
		double x2 = getForme().getPosition().getOrdonnee();
		double width = getForme().getLargeur();
		double height = getForme().getHauteur();
		
		Ellipse2D ellipse = new Ellipse2D.Double(x1, x2, width, height);
		
		g2d.draw(ellipse);
		
	}

}
