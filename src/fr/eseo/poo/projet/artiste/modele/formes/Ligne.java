package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme{

	
	public Ligne() {
		
	}
	
	public Ligne(double largeur, double hauteur) {
		
	}
	
	public Ligne (Coordonnees coordonnees) {
		
	}
	
	public Ligne (Coordonnees coordonnees, double largeur, double hauteur) {
		
	}

	public Coordonnees getC1() {
		return getPosition();
	}

	public void setC1(Coordonnees c1) {
		super.setPosition(c1);
		setLargeur(getLargeur() + (getPosition().getAbscisse() - c1.getAbscisse()) );
	
		
	}

	public Coordonnees getC2() {
		return new Coordonnees(getPosition().getAbscisse() + getLargeur(), getPosition().getOrdonnee() + getHauteur());
	}

	public void setC2(Coordonnees c2) {
		super.setPosition();
	}
	
	
	@Override
	public String toString() {
		return "Ligne [c1=" + c1 + ", c2=" + c2 + "]";
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

}
