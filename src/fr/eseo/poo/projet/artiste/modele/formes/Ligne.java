package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme{

	
	public Ligne() {
		super();
	}
	
	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
	}
	
	public Ligne (Coordonnees coordonnees) {
		super(coordonnees);
	}
	
	public Ligne (Coordonnees coordonnees, double largeur, double hauteur) {
		super(coordonnees, largeur, hauteur);
	}

	public Coordonnees getC1() {
		return getPosition();
	}

	public void setC1(Coordonnees c1) {
		super.setLargeur(super.getLargeur() + (super.getPosition().getAbscisse() - c1.getAbscisse()));
		super.setHauteur(super.getHauteur() + (super.getPosition().getOrdonnee() - c1.getOrdonnee()));
		super.setPosition(c1);
	
	}

	public Coordonnees getC2() {
		return new Coordonnees(getPosition().getAbscisse() + getLargeur(), getPosition().getOrdonnee() + getHauteur());
	}

	public void setC2(Coordonnees c2) {
		super.setLargeur(c2.getAbscisse() - getC1().getAbscisse());
		super.setHauteur(c2.getOrdonnee() - getC1().getOrdonnee());
		
	}
	
	
	@Override
	public String toString() {
		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#.0#");
		
		String c1 = "c1 : (" + df.format(getC1().getAbscisse()) + " , " + df.format(getC1().getOrdonnee()) + ") ";
		String c2 = "c2 : (" + df.format(getC2().getAbscisse()) + " , " + df.format(getC2().getOrdonnee()) + ") ";
		String longueur = "longueur : " + df.format(perimetre()) + " ";
		String angle = "angle : " + df.format(180 * getC1().angleVers(getC2()) / Math.PI) + "°";
		return "[Ligne] " + c1 + c2 + longueur + angle;
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return getC1().distanceVers(getC2());
	}

}
