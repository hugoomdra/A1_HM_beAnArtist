package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ellipse extends Forme{

	public Ellipse() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Ellipse(double largeur, double hauteur){
		this(new Coordonnees(), largeur, hauteur);
	}
	
	public Ellipse(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Ellipse(Coordonnees coordonnees, double largeur, double hauteur) {
		setPosition(coordonnees);
		setLargeur(largeur);
		setHauteur(hauteur);
	}
	
	@Override
	public void setHauteur(double hauteur) throws IllegalArgumentException{
		if(hauteur < 0) {
			throw new IllegalArgumentException();
		}
		super.setHauteur(hauteur);
	}
	
	@Override
	public void setLargeur(double largeur) throws IllegalArgumentException {
		if(largeur < 0) {
			throw new IllegalArgumentException();
		}
		super.setLargeur(largeur);
	}
	
	public String toString() {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#0.0#");
		
		String pos = "pos (" + df.format(getPosition().getAbscisse()) + " , " + df.format(getPosition().getOrdonnee()) + ")";
		String dim = "dim " + df.format(getLargeur()) +" x " + df.format(getHauteur());
		String perimetre = "périmètre : " + df.format(perimetre());
		String aire = "aire : " + df.format(aire());
		return "["+ this.getClass().getSimpleName() +"] : " + pos + " " + dim + " " + perimetre + " " + aire;
	}

	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return Math.PI * (getHauteur() /2) * (getLargeur()/2);
	}

	@Override
	public double perimetre() {
		double petitRayon = (getHauteur() /2) < (getLargeur() /2) ? (getHauteur() /2) : (getLargeur() /2);
		double grandRayon = (getHauteur() /2) < (getLargeur() /2) ? (getLargeur() /2) : (getHauteur() /2);
		
		double h = Math.pow((petitRayon - grandRayon) / (petitRayon + grandRayon), 2);
		
		double perimetre = Math.PI * (petitRayon + grandRayon) * (1 + ((3 * h)/(10 + Math.sqrt(4 - 3 * h))));
		return perimetre;
	}
	
	@Override
	public boolean contient(Coordonnees coordonnees) {
		
		/*
		 * J'ai récupéré la formule sur ce site :
		 * https://math.stackexchange.com/questions/76457/check-if-a-point-is-within-an-ellipse
		 */
		
		double petitRayon = (getHauteur() /2) < (getLargeur() /2) ? (getHauteur() /2) : (getLargeur() /2);
		double grandRayon = (getHauteur() /2) < (getLargeur() /2) ? (getLargeur() /2) : (getHauteur() /2);
		
		double abscisse = (Math.pow(coordonnees.getAbscisse() - getCentre().getAbscisse() , 2) / Math.pow(grandRayon, 2));
		double ordonnee = (Math.pow(coordonnees.getOrdonnee() - getCentre().getOrdonnee(), 2) / Math.pow(petitRayon, 2));
			
		return abscisse + ordonnee <= 1;
	}
	
	public Coordonnees getCentre() {

		return new Coordonnees(getPosition().getAbscisse() + (getLargeur() / 2), getPosition().getOrdonnee() + (getHauteur() / 2));
	}
	

}
