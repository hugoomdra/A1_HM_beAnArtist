package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	private static final double EPSILON = 1e-3d;
	
	@Test
	public void constructeur1() {
		Cercle cercle = new Cercle();
		
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(), cercle.getPosition());
	}
	
	@Test
	public void constructeur2() {
		Cercle cercle = new Cercle(50);
		
		assertEquals(50, cercle.getHauteur(), EPSILON);
		assertEquals(50, cercle.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(), cercle.getPosition());
	}
	
	@Test
	public void constructeur3() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25), 50);
		
		assertEquals(50, cercle.getHauteur(), EPSILON);
		assertEquals(50, cercle.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(15, 25), cercle.getPosition());
	}
	
	@Test
	public void constructeur4() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25));
		
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(15, 25), cercle.getPosition());
	}
	
	@Test
	public void setHauteur() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25));
		
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		cercle.setHauteur(40);
		assertEquals(40, cercle.getHauteur(), EPSILON);
		assertEquals(40, cercle.getLargeur(), EPSILON);
		
	}
	
	@Test
	public void setLargeur() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25));
		
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		cercle.setLargeur(40);
		assertEquals(40, cercle.getHauteur(), EPSILON);
		assertEquals(40, cercle.getLargeur(), EPSILON);
		
	}
	
	@Test
	public void aire() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25), 50);
		
		assertEquals(1963.495, cercle.aire(), EPSILON);

	}
	
	@Test
	public void perimetre() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25), 50);
		
		assertEquals(157.08, cercle.perimetre(), EPSILON);

	}
	
	
	
	@Test
	public void testToString() {
		Cercle cercle = new Cercle(new Coordonnees(122, 78), 50);
		
		assertEquals("[Cercle] : pos (122,0 , 78,0) dim 50,0 x 50,0 périmètre : 157,08 aire : 1963,5", cercle.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Cercle] : pos (122.0 , 78.0) dim 50.0 x 50.0 périmètre : 157.08 aire : 1963.5", cercle.toString());
		Locale.setDefault(Locale.FRENCH);
		
	}
	
	@Test
	public void contient() {
		Cercle cercle = new Cercle(new Coordonnees(2, -8), 10);

		Coordonnees coordB = new Coordonnees(7, 2);
		Coordonnees coordC = new Coordonnees(4, -3);
		Coordonnees coordD = new Coordonnees(2, -7);
		Coordonnees coordE = new Coordonnees(3, -6);
		Coordonnees coordF = new Coordonnees(12, -3);
		Coordonnees coordG = new Coordonnees(14, -5);
		
		assertEquals(true, cercle.contient(coordB));
		assertEquals(true, cercle.contient(coordC));
		assertEquals(true, cercle.contient(coordE));
		assertEquals(true, cercle.contient(coordF));
		assertEquals(false, cercle.contient(coordD));
		assertEquals(false, cercle.contient(coordG));
		
	}

}
