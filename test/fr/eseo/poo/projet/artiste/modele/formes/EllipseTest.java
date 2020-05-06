package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	private static final double EPSILON = 1e-3d;
	
	@Test
	public void testConstructeur1() {
		Ellipse ellipse = new Ellipse();
		
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(), ellipse.getPosition());
	}
	
	@Test
	public void testConstructeur2() {
		Ellipse ellipse = new Ellipse(10, 20);
		
		assertEquals(20, ellipse.getHauteur(), EPSILON);
		assertEquals(10, ellipse.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(), ellipse.getPosition());
	}
	
	@Test
	public void testConstructeur3() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25) ,10, 20);
		
		assertEquals(20, ellipse.getHauteur(), EPSILON);
		assertEquals(10, ellipse.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(15, 25), ellipse.getPosition());
	}
	
	@Test
	public void testConstructeur4() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25));
		
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getHauteur(), EPSILON);
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(15, 25), ellipse.getPosition());
	}
	
	@Test
	public void setHauteur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25));
		
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), EPSILON);
		ellipse.setHauteur(40);
		assertEquals(40, ellipse.getHauteur(), EPSILON);
		
	}
	
	@Test
	public void setLargeur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25));
		
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), EPSILON);
		ellipse.setLargeur(40);
		assertEquals(40, ellipse.getLargeur(), EPSILON);
		
	}
	
	@Test
	public void aire() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25), 20, 16);
		
		assertEquals(251.327, ellipse.aire(), EPSILON);

	}
	
	@Test
	public void perimetre() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25), 20, 16);
		
		assertEquals(56.723, ellipse.perimetre(), EPSILON);

	}
	
	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		assertEquals("[Ellipse] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 63,82 aire : 294,52", ellipse.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Ellipse] : pos (10.0 , 10.0) dim 25.0 x 15.0 périmètre : 63.82 aire : 294.52", ellipse.toString());
		Locale.setDefault(Locale.FRENCH);
	
	
	}
	
	@Test
	public void testContient() {
		Ellipse ellipse = new Ellipse(new Coordonnees(1, 2), 5, 4);
		
		Coordonnees coordB = new Coordonnees(3.52, 2.02);
		Coordonnees coordC = new Coordonnees(2, 4);
		Coordonnees coordD = new Coordonnees(7, 8);
		Coordonnees coordE = new Coordonnees(5, 4);

		
		assertEquals(true, ellipse.contient(coordB));
		assertEquals(true, ellipse.contient(coordC));
		assertEquals(false, ellipse.contient(coordD));
		assertEquals(true, ellipse.contient(coordE));
		
		
	}

}
