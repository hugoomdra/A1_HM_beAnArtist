package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	private static final double EPSILON = 1e-3d;
	
	@Test
	public void testConstructeur1() {
		Cercle cercle = new Cercle();
		
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(), cercle.getPosition());
	}
	
	@Test
	public void testConstructeur2() {
		Cercle cercle = new Cercle(50);
		
		assertEquals(50, cercle.getHauteur(), EPSILON);
		assertEquals(50, cercle.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(), cercle.getPosition());
	}
	
	@Test
	public void testConstructeur3() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25), 50);
		
		assertEquals(50, cercle.getHauteur(), EPSILON);
		assertEquals(50, cercle.getLargeur(), EPSILON);
		assertEquals(new Coordonnees(15, 25), cercle.getPosition());
	}
	
	@Test
	public void testConstructeur4() {
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

}
