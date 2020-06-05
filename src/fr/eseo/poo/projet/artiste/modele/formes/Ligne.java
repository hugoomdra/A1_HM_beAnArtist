package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme{

	public static final double EPSILON = 0.1;
	
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
	public double getCadreMinX() {
		return getLargeur() < 0 ? getPosition().getAbscisse() + getLargeur() : getPosition().getAbscisse();
	}
	
	@Override
	public double getCadreMinY() {
		
		return getHauteur() < 0 ? getPosition().getOrdonnee() + getHauteur() : getPosition().getOrdonnee();
	}
	
	@Override
	public double getCadreMaxX() {
		return getLargeur() < 0 ? getPosition().getAbscisse() : getPosition().getAbscisse() + getLargeur();
	}
	
	@Override
	public double getCadreMaxY() {
		return getHauteur() < 0 ? getPosition().getOrdonnee() : getPosition().getOrdonnee() + getHauteur();
	}
	
	public double getAngleDegree() {

		double deg = 360 / (2 * Math.PI) * getC1().angleVers(getC2());
		if (deg < 0) {
			deg = 360 + deg;
		}
		return deg;
		//		return 180 * getC1().angleVers(getC2()) / Math.PI;
	}
	
	@Override
	public String toString() {
		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#0.0#");
		
		String c1 = "c1 : (" + df.format(getC1().getAbscisse()) + " , " + df.format(getC1().getOrdonnee()) + ") ";
		String c2 = "c2 : (" + df.format(getC2().getAbscisse()) + " , " + df.format(getC2().getOrdonnee()) + ") ";
		String longueur = "longueur : " + df.format(perimetre()) + " ";
		String angle = "angle : " + df.format(getAngleDegree()) + "° ";
		
		String couleur = "";
		int rouge = getCouleur().getRed();
        int vert = getCouleur().getGreen();
        int bleu = getCouleur().getBlue();

        if (Locale.getDefault().getLanguage().equals(new Locale("fr").getLanguage())) {
            couleur = "couleur = R" + rouge + ",V" + vert + ",B" + bleu;
        } else {
        	couleur = "couleur = R" + rouge + ",G" + vert + ",B" + bleu;
        }

		return "[Ligne] " + c1 + c2 + longueur + angle + couleur;
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
	
	@Override
	public boolean contient(Coordonnees coordonnees) {
		
		return getC1().distanceVers(coordonnees) + coordonnees.distanceVers(getC2()) - getC1().distanceVers(getC2()) < EPSILON;
	}

}
