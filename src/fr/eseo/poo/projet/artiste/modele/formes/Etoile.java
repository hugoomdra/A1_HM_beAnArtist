package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Point;
import java.awt.Polygon;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {

	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.75;

	private List<Coordonnees> coordonnees;

	private int nombreBranches;
	private double anglePremiereBranche;
	private double longueurBranche;
	private boolean estRempli;

	public Etoile() {
		this(new Coordonnees(), HAUTEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(double taille) {
		this(new Coordonnees(), taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees coordonnees) {
		this(coordonnees, HAUTEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees coordonnees, double taille) {
		this(coordonnees, taille, NOMBRE_BRANCHES_PAR_DEFAUT, ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	public Etoile(Coordonnees coordonnees, double taille, int nombreBranches, double anglePremiereBranche,
			double longueurBranche) {
		super(coordonnees, taille, taille);

		if (taille < 0) {
			throw new IllegalArgumentException();
		} else if (nombreBranches < 3 || nombreBranches > 15) {
			throw new IllegalArgumentException();
		} else if (longueurBranche <= 0 || longueurBranche >= 1) {
			throw new IllegalArgumentException();
		} else if (anglePremiereBranche < -Math.PI || anglePremiereBranche > Math.PI) {
			throw new IllegalArgumentException();
		}

		this.nombreBranches = nombreBranches;
		this.anglePremiereBranche = anglePremiereBranche;
		this.longueurBranche = longueurBranche;
		this.estRempli = false;
		
		calculerLesSommets();
	}

	private void calculerLesSommets() {

		this.coordonnees = new ArrayList<Coordonnees>();
		
		double rayon = getLargeur() / 2;
		
		double angle = getAnglePremiereBranche();
		double etape = 0;

		double centreX = this.getPosition().getAbscisse() + this.getLargeur() / 2;
		double centreY = this.getPosition().getOrdonnee() + this.getLargeur() / 2;
		Coordonnees centre = new Coordonnees(centreX, centreY);
		double x, y;
		
		for (int c = 0; c < getNombreBranches() * 2; c++) {
			
			
			if (c % 2 == 0) {
				x = centre.getAbscisse() + rayon * Math.cos(angle - etape);
				y = centre.getOrdonnee() + rayon * Math.sin(angle - etape);
			} else {
				
				x = centre.getAbscisse() + (rayon * (1 - getLongueurBranche())) * (Math.cos(angle - etape));
				y = centre.getOrdonnee() + (rayon * (1 - getLongueurBranche())) * (Math.sin(angle - etape));
			}
			
			getCoordonnees().add(new Coordonnees(x, y));
			etape += Math.PI / getNombreBranches();
			
		}
	}

	@Override
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
		this.calculerLesSommets();
	}

	@Override
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		super.setLargeur(largeur);
		this.calculerLesSommets();
	}

	public List<Coordonnees> getCoordonnees() {
		return coordonnees;
	}

	public double getAnglePremiereBranche() {
		return anglePremiereBranche;
	}

	public void setAnglePremiereBranche(double anglePremiereBranche) {
		if (anglePremiereBranche < -Math.PI || anglePremiereBranche > Math.PI) {
			throw new IllegalArgumentException();
		}
		this.anglePremiereBranche = anglePremiereBranche;
		this.calculerLesSommets();
	}

	public double getLongueurBranche() {
		return longueurBranche;
	}

	
	public void setLongueurBranche(double longueurBranche) {
		if (longueurBranche <= 0 || longueurBranche >= 1) {
			throw new IllegalArgumentException();
		}
		this.longueurBranche = longueurBranche;
		this.calculerLesSommets();
	}

	public int getNombreBranches() {
		return nombreBranches;
	}

	public void setNombreBranches(int nombreBranches) {
		if (nombreBranches > 15 || nombreBranches < 3) {
			throw new IllegalArgumentException();
		}
		this.nombreBranches = nombreBranches;
		this.calculerLesSommets();
	}

	@Override
	public boolean estRempli() {
		
		return this.estRempli;
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.estRempli = modeRemplissage;
		
	}

	
	@Override
	public double aire() {
		
		double centreX = this.getPosition().getAbscisse() + this.getLargeur() / 2;
		double centreY = this.getPosition().getOrdonnee() + this.getLargeur() / 2;
		
		Coordonnees point0 = getCoordonnees().get(0);
		Coordonnees point1 = getCoordonnees().get(1);
		Coordonnees point3 = getCoordonnees().get(3);


		double petiteDistance = point1.distanceVers(point3);
		double grandeDistance = point0.distanceVers(new Coordonnees(centreX, centreY));
		
		double aireCerfVolant = petiteDistance * grandeDistance / 2;
		return aireCerfVolant * getNombreBranches();
		
		
		

		

		

	}

	@Override
	public double perimetre() {
		
	
		Coordonnees point1 = getCoordonnees().get(0);
		Coordonnees point2 = getCoordonnees().get(1);
			
		double perimetre = point1.distanceVers(point2) * 2 * getNombreBranches();
		
		System.out.println(getNombreBranches());
        return perimetre;


	}

	@Override
	public boolean contient(Coordonnees laCoordonnees) {
		
		int[] tabX = new int[getCoordonnees().size()];
		int[] tabY = new int[getCoordonnees().size()];
		int c = 0;
		for (int i = 0; i < getCoordonnees().size(); i++) {
			tabX[i] = (int) Math.round(getCoordonnees().get(i).getAbscisse());
			tabY[i] = (int) Math.round(getCoordonnees().get(i).getOrdonnee());
			c++;
		}
		
		Polygon etoile = new Polygon(tabX, tabY, c);
		
		System.out.println(etoile);
	
		return etoile.contains(new Point((int) Math.round(laCoordonnees.getAbscisse()),  (int) Math.round(laCoordonnees.getOrdonnee())));
	}

	
	public String toString() {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#0.0#");
		
		String pos = "pos (" + df.format(getPosition().getAbscisse()) + " , " + df.format(getPosition().getOrdonnee()) + ")";
		String dim = "dim " + df.format(getLargeur()) +" x " + df.format(getHauteur());
		String perimetre = "périmètre : " + df.format(perimetre());
		String aire = "aire : " + df.format(aire());
		
		
		String couleur = "";
		int rouge = getCouleur().getRed();
        int vert = getCouleur().getGreen();
        int bleu = getCouleur().getBlue();

        if (Locale.getDefault().getLanguage().equals(new Locale("fr").getLanguage())) {
            couleur = "couleur = R" + rouge + ",V" + vert + ",B" + bleu;
        } else {
        	couleur = "couleur = R" + rouge + ",G" + vert + ",B" + bleu;
        }
		
		
		String firstPhrase = "["+ this.getClass().getSimpleName() + (estRempli() ? "-Rempli" : "") +"] : " + pos + " ";
				return firstPhrase + dim + " " + perimetre + " " + aire + " " + couleur;
	}


}
