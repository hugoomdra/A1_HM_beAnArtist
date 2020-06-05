package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme {
	public VueEtoile(Etoile etoile) {

		super(etoile);
	}
	
	@Override
	public Etoile getForme() {
		return (Etoile) super.getForme();
	}
	
	@Override
	public void affiche(Graphics2D g2d) {
	
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		int[] tabX = new int[getForme().getCoordonnees().size()];
		int[] tabY = new int[getForme().getCoordonnees().size()];
		int c = 0;
		for (int i = 0; i < getForme().getCoordonnees().size(); i++) {
			tabX[i] = (int) Math.round(getForme().getCoordonnees().get(i).getAbscisse());
			tabY[i] = (int) Math.round(getForme().getCoordonnees().get(i).getOrdonnee());
			c++;
		}
		
		Polygon etoile = new Polygon(tabX, tabY, c);
		
		
		Color couleurSauvegardee = g2d.getColor();
		g2d.setColor(getForme().getCouleur());
		
		if(getForme().estRempli()) {
			g2d.fill(etoile);
		}
		
		g2d.draw(etoile);
		
		g2d.setColor(couleurSauvegardee);
	}

}
