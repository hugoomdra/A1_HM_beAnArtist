package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse{

	public Cercle() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille) {
		this(new Coordonnees(), taille);
	}
	
	public Cercle(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Coordonnees coordonnees, double taille) {
		setPosition(coordonnees);
		setLargeur(taille);
	}
	
	@Override
	public void setHauteur(double hauteur) throws IllegalArgumentException {
		if(hauteur < 0) {
			throw new IllegalArgumentException();
		}
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
	
	@Override
	public void setLargeur(double largeur) throws IllegalArgumentException {
		if(largeur < 0) {
			throw new IllegalArgumentException();
		}
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	@Override
	public double perimetre() {
		return 2 * Math.PI * (getHauteur() / 2);
	}
	
	
	
	
}
