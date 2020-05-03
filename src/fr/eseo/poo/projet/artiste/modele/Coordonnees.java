package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Coordonnees {

	public static final double ABSCISSE_PAR_DEFAUT = 0;
	public static final double ORDONNEE_PAR_DEFAUT = 0;

	private double abscisse;
	private double ordonnee;

	public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}

	public Coordonnees(double abscisse, double ordonnee) {
		setAbscisse(abscisse);
		setOrdonnee(ordonnee);
	}

	public double getAbscisse() {
		return this.abscisse;
	}

	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}

	public double getOrdonnee() {
		return this.ordonnee;
	}

	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}

	/**
	 * Fonction qui permet de déplacer la coordonnée à un autre endroit.
	 * 
	 * @param abscisse La nouvelles abscisse de la coordonnees.
	 * @param ordonnee La nouvelles ordonnees de la coordonnees.
	 */
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.setAbscisse(nouvelleAbscisse);
		this.setOrdonnee(nouvelleOrdonnee);
	}

	/**
	 * 
	 * Fonction qui permet de déplacer la coordonnée en fonction des arguments
	 * 
	 * @param deltaAbscisse déplacement en X
	 * @param deltaOrdonnee déplacement en Y
	 */
	public void deplacerDe(double deltaAbscisse, double deltaOrdonnee) {
		this.setAbscisse(this.getAbscisse() + deltaAbscisse);
		this.setOrdonnee(this.getOrdonnee() + deltaOrdonnee);
	}

	/**
	 * 
	 * Fonction qui permet de connaitre la distance deux points.
	 * 
	 * @param coord une coordonnée
	 * @return la distance entre la coordonnées et la coordonnée donnée en argument
	 */
	public double distanceVers(Coordonnees coord) {
		return  (double) Math.round((Math.sqrt(Math.pow(coord.getAbscisse() - this.getAbscisse(), 2)
				+ Math.pow(coord.getOrdonnee() - this.getOrdonnee(), 2))) * 1000) / 1000;
	}

	/**
	 * 
	 * Fonction qui permet de connaitre l'angle entre deux points.
	 * 
	 * @param coord une coordonnée
	 * @return l'angle entre la coordonnées et la coordonnée donnée en argument
	 */
	public double angleVers(Coordonnees coord) {
		double res = Math.atan(Math.abs(coord.getOrdonnee() - this.getOrdonnee())
				/ Math.abs(coord.getAbscisse() - this.getAbscisse()));
		
		if(coord.getAbscisse() < this.getAbscisse()) {
			res = Math.PI - res;
		}
		
		if(coord.getOrdonnee() < this.getOrdonnee()) {
			res = -res;
		}
		
		
		return res;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#0.0#");
		return "(" + df.format(this.getAbscisse()) + " , " + df.format(this.getOrdonnee()) + ")";
	}

}

