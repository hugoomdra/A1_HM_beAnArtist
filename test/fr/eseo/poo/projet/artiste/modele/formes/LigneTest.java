package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import javax.swing.UIManager;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	private static final double EPSILON = 1e-3d;

	@Test
	public void testConstructeurParDefaut() {

		Ligne laLigne = new Ligne();
		assertEquals("Test de la largeur", Ligne.LARGEUR_PAR_DEFAUT, laLigne.getLargeur(), EPSILON);
		assertEquals("Test de la hauteur", Ligne.HAUTEUR_PAR_DEFAUT, laLigne.getHauteur(), EPSILON);
		assertEquals("Test de l'abscisse", Coordonnees.ABSCISSE_PAR_DEFAUT, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test de l'ordonnee", Coordonnees.ORDONNEE_PAR_DEFAUT, laLigne.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(), laLigne.getPosition());
		
	}
	
	@Test
	public void testConstructeurPosition() {

		Ligne laLigne = new Ligne(new Coordonnees(20, 30));
		assertEquals("Test de la largeur", Ligne.LARGEUR_PAR_DEFAUT, laLigne.getLargeur(), EPSILON);
		assertEquals("Test de la hauteur", Ligne.HAUTEUR_PAR_DEFAUT, laLigne.getHauteur(), EPSILON);
		assertEquals("Test de l'abscisse", 20, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test de l'ordonnee", 30, laLigne.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(20, 30), laLigne.getPosition());
		
	}
	
	@Test
	public void testConstructeurDimension() {

		Ligne laLigne = new Ligne(40, 50);

		assertEquals("Test de la largeur", 40, laLigne.getLargeur(), EPSILON);
		assertEquals("Test de la hauteur", 50, laLigne.getHauteur(), EPSILON);
		assertEquals("Test de l'abscisse", Coordonnees.ABSCISSE_PAR_DEFAUT, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test de l'ordonnee", Coordonnees.ORDONNEE_PAR_DEFAUT, laLigne.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(), laLigne.getPosition());
		
	}

	@Test
    public void testGetCadreMin() {
        Ligne test = new Ligne(new Coordonnees(3.14, 3.14), 16.2, -1.36);
        assertEquals("Abscisse minimal du cadre", 3.14, test.getCadreMinX(), EPSILON);
        assertEquals("Ordonnée minimal du cadre", 1.78, test.getCadreMinY(), EPSILON);
    }

    @Test
    public void testGetCadreMax() {
        Ligne test = new Ligne(new Coordonnees(20, 15), -3, 6);
        assertEquals("Abscisse maximal du cadre", 20, test.getCadreMaxX(), EPSILON);
        assertEquals("Ordonnée maximal du cadre", 21, test.getCadreMaxY(), EPSILON);
    }

	
	@Test
	public void testConstructeurAll() {

		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);

		assertEquals("Test de la largeur", 20, laLigne.getLargeur(), EPSILON);
		assertEquals("Test de la hauteur", 30, laLigne.getHauteur(), EPSILON);
		assertEquals("Test de l'abscisse", 5, laLigne.getPosition().getAbscisse(), EPSILON);
		assertEquals("Test de l'ordonnee", 6, laLigne.getPosition().getOrdonnee(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(5, 6), laLigne.getC1());
		
	}
	
	@Test
	public void getC1() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);
		assertEquals("Test de coordonnees", new Coordonnees(5, 6), laLigne.getC1());

	}
	
	@Test
	public void setC1() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 5, 2);
		laLigne.setC1(new Coordonnees(1, 2));
		
		
		assertEquals("Test de coordonnees", new Coordonnees(1, 2), laLigne.getC1());
		assertEquals("Test de la largeur", 9, laLigne.getLargeur(), EPSILON);
		assertEquals("Test de la hauteur", 6, laLigne.getHauteur(), EPSILON);
	}
	
	@Test
	public void getC2() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);
		assertEquals("Test de coordonnees", new Coordonnees(25, 36), laLigne.getC2());

	}
	
	@Test
	public void setC2() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 5, 2);
		laLigne.setC2(new Coordonnees(1, 2));
		
		assertEquals("Test de coordonnees", new Coordonnees(1, 2), laLigne.getC2());
		assertEquals("Test de la largeur", -4, laLigne.getLargeur(), EPSILON);
		assertEquals("Test de la hauteur", -4, laLigne.getHauteur(), EPSILON);
	}
	
	
	
	@Test
	public void aire() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 20, 30);
		assertEquals("Test de l'aire", 0, laLigne.aire(), EPSILON);
	}
	
	@Test
	public void perimetre() {
		Ligne laLigne = new Ligne(new Coordonnees(5, 6), 4, 8);
		assertEquals("Test du perimetre", 8.944, laLigne.perimetre(), EPSILON);
	}
	
	
	@Test
	public void testToString() {
		Ligne laLigne = new Ligne(new Coordonnees(10, 10), -5, 20);
		
		assertEquals("Test du toString FR", "[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04° couleur = R51,V51,B51", laLigne.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Test du toString EN", "[Ligne] c1 : (10.0 , 10.0) c2 : (5.0 , 30.0) longueur : 20.62 angle : 104.04° couleur = R51,G51,B51", laLigne.toString());
		Locale.setDefault(Locale.FRENCH);
			
	}
	
	
	@Test
	public void contient() {
		Ligne laLigne = new Ligne(new Coordonnees(2, 1));
		
		laLigne.setC2(new Coordonnees(23, 19));
		assertTrue("Test point non contenu", laLigne.contient(new Coordonnees(9, 7)));
		
		laLigne.setC2(new Coordonnees(23, 40));
		assertFalse("Test point contenu", laLigne.contient(new Coordonnees(9, 7)));
	}
	
	@Test
    public void testGetCouleur() {
        Ligne laLigne = new Ligne();
        assertEquals("Couleur par défaut", UIManager.getColor("Panel.foreground"), laLigne.getCouleur());
    }

    @Test
    public void testSetCouleur() {
        Ligne laLigne = new Ligne();
        laLigne.setCouleur(Color.RED);
        assertEquals("Set de la couleur", Color.RED, laLigne.getCouleur());
    }

	

	


}
