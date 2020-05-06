package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void constructeur1() {

		Ligne laLigne = new Ligne();

		assertEquals(Ligne.LARGEUR_PAR_DEFAUT, laLigne.getLargeur(), EPSILON);
		assertEquals(Ligne.HAUTEUR_PAR_DEFAUT, laLigne.getHauteur(), EPSILON);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, laLigne.getPosition().getOrdonnee(), EPSILON);
		
	}
	
	@Test
	public void constructeur2() {

		Ligne laLigne = new Ligne(20, 30);

		assertEquals(20, laLigne.getLargeur(), EPSILON);
		assertEquals(30, laLigne.getHauteur(), EPSILON);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, laLigne.getPosition().getOrdonnee(), EPSILON);
		
	}
	
	@Test
	public void constructeur3() {

		Ligne laLigne = new Ligne(new Coordonnees(5, 6));

		assertEquals(Ligne.LARGEUR_PAR_DEFAUT, laLigne.getLargeur(), EPSILON);
		assertEquals(Ligne.HAUTEUR_PAR_DEFAUT, laLigne.getHauteur(), EPSILON);
		assertEquals(5, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals(6, laLigne.getPosition().getOrdonnee(), EPSILON);
		
	}
	
	@Test
	public void constructeur4() {

		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);

		assertEquals(20, laLigne.getLargeur(), EPSILON);
		assertEquals(30, laLigne.getHauteur(), EPSILON);
		assertEquals(5, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals(6, laLigne.getPosition().getOrdonnee(), EPSILON);
		
	}
	
	@Test
	public void getC1() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);
		assertEquals(5, laLigne.getC1().getAbscisse(), EPSILON);
		assertEquals(6, laLigne.getC1().getOrdonnee(), EPSILON);

	}
	
	

	@Test
	public void setC1() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 5, 2);
		laLigne.setC1(new Coordonnees(1, 2));
		
		
		assertEquals(1, laLigne.getC1().getAbscisse(), EPSILON);
		assertEquals(2, laLigne.getC1().getOrdonnee(), EPSILON);
		assertEquals(9, laLigne.getLargeur(), EPSILON);
		assertEquals(6, laLigne.getHauteur(), EPSILON);
	}
	
	@Test
	public void setC2() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 5, 2);
		laLigne.setC2(new Coordonnees(1, 2));
		
		
		assertEquals(1, laLigne.getC2().getAbscisse(), EPSILON);
		assertEquals(2, laLigne.getC2().getOrdonnee(), EPSILON);
		assertEquals(-4, laLigne.getLargeur(), EPSILON);
		assertEquals(-4, laLigne.getHauteur(), EPSILON);
	}
	
	@Test
	public void getC2() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);
		assertEquals(25, laLigne.getC2().getAbscisse(), EPSILON);
		assertEquals(36, laLigne.getC2().getOrdonnee(), EPSILON);

	}
	
	@Test
	public void aire() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);
		assertEquals(0, laLigne.aire(), EPSILON);
	}
	
	@Test
	public void perimetre() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 4, 8);
		assertEquals(8.944, laLigne.perimetre(), EPSILON);
	}
	
	
	@Test
	public void testToString() {
		Ligne laLigne = new Ligne(new Coordonnees(10, 10), -5, 20);
		
		assertEquals("[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04°", laLigne.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Ligne] c1 : (10.0 , 10.0) c2 : (5.0 , 30.0) longueur : 20.62 angle : 104.04°", laLigne.toString());
		Locale.setDefault(Locale.FRENCH);
	}
	
	@Test
	public void testPdf() {
		Ligne laLignePage54 = new Ligne(new Coordonnees(77, 177), 156, -100);
		assertEquals(77, laLignePage54.getCadreMinX(), EPSILON);
		assertEquals(77, laLignePage54.getCadreMinY(), EPSILON);
		assertEquals(233, laLignePage54.getCadreMaxX(), EPSILON);
		assertEquals(177, laLignePage54.getCadreMaxY(), EPSILON);
		
		assertEquals("[Ligne] c1 : (77,0 , 177,0) c2 : (233,0 , 77,0) longueur : 185,3 angle : 327,34°", laLignePage54.toString() );
	
	}
	
	
	@Test
	public void contient() {
		Ligne laLigne = new Ligne(new Coordonnees(2, 1));
		
		laLigne.setC2(new Coordonnees(23, 19));
		assertEquals(true, laLigne.contient(new Coordonnees(9, 7)));
		
		laLigne.setC2(new Coordonnees(23, 40));
		assertEquals(false, laLigne.contient(new Coordonnees(9, 7)));
	}
	

	


}
