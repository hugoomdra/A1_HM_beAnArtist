package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public abstract class Forme {

	public static final double LARGEUR_PAR_DEFAUT = 10;
	public static final double HAUTEUR_PAR_DEFAUT = 10;
	
	private double largeur;
	private double hauteur;
	private Coordonnees position;
	
	public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(Coordonnees position, double largeur, double hauteur) {
		setPosition(position);
		setLargeur(largeur);
		setHauteur(hauteur);
		
	}

	public double getLargeur() {
		return largeur;
	}

	public double getHauteur() {
		return hauteur;
	}

	
	public Coordonnees getPosition() {
		return position;
	}
	
	public double getCadreMinX() {
		return getPosition().getAbscisse();
	}
	
	public double getCadreMinY() {
		return getPosition().getOrdonnee();
	}
	
	public double getCadreMaxX() {
		return getPosition().getAbscisse() + getLargeur();
	}
	
	public double getCadreMaxY() {
		return getPosition().getOrdonnee() + getHauteur();
	}
	
	public void setPosition(Coordonnees position) {
		this.position = position;
	}
	
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		position.deplacerDe(deltaX, deltaY);
	}
	
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		position.deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}
	
	abstract public double aire();
	
	abstract public double perimetre();
	
	abstract public boolean contient(Coordonnees coordonnees);
	
	
	
}
