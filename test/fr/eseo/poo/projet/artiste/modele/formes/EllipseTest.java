package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import javax.swing.UIManager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	private static final double EPSILON = 1e-3d;
	
	@Rule
    public final ExpectedException expectedException = ExpectedException.none();

	
	@Test
	public void testConstructeurParDefaut() {
		Ellipse ellipse = new Ellipse();
		
		assertEquals("Test de la hauteur", Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(), ellipse.getPosition());
	}
	
	@Test
	public void testConstructeurDimension() {
		Ellipse ellipse = new Ellipse(10, 20);
		
		assertEquals("Test de la hauteur", 20, ellipse.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", 10, ellipse.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(), ellipse.getPosition());
	}
	
	@Test
	public void testConstructeurAll() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25) ,10, 20);
		
		assertEquals("Test de la hauteur", 20, ellipse.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", 10, ellipse.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(15, 25), ellipse.getPosition());
	}
	
	@Test
	public void testConstructeurPosition() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25));
		
		assertEquals("Test de la largeur", Forme.LARGEUR_PAR_DEFAUT, ellipse.getHauteur(), EPSILON);
		assertEquals("Test de la hauteur", Forme.HAUTEUR_PAR_DEFAUT, ellipse.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(15, 25), ellipse.getPosition());
	}
	
	@Test
	public void setHauteur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25));
		ellipse.setHauteur(40);
		assertEquals("Test du set hauteur", 40, ellipse.getHauteur(), EPSILON);
		
	}
	
	@Test
	public void setLargeur() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25));
		
		ellipse.setLargeur(40);
		assertEquals("Test du set largeur", 40, ellipse.getLargeur(), EPSILON);
		
	}
	
	@Test
	public void aire() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25), 20, 16);
		
		assertEquals("Test de l'aire", 251.327, ellipse.aire(), EPSILON);

	}
	
	@Test
	public void perimetre() {
		Ellipse ellipse = new Ellipse(new Coordonnees(15, 25), 20, 16);
		
		assertEquals("Test du perimetre", 56.723, ellipse.perimetre(), EPSILON);

	}
	
	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		assertEquals("Test du toString FR", "[Ellipse] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 63,82 aire : 294,52 couleur = R51,V51,B51", ellipse.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Test du toString EN", "[Ellipse] : pos (10.0 , 10.0) dim 25.0 x 15.0 périmètre : 63.82 aire : 294.52 couleur = R51,G51,B51", ellipse.toString());
		Locale.setDefault(Locale.FRENCH);
	
	
	}
	
	@Test
	public void testContient() {
		Ellipse ellipse = new Ellipse(new Coordonnees(1, 2), 5, 4);
		
		Coordonnees coordB = new Coordonnees(3.52, 2.02);
		Coordonnees coordC = new Coordonnees(2, 4);
		Coordonnees coordD = new Coordonnees(7, 8);
		Coordonnees coordE = new Coordonnees(5, 4);

		
		assertTrue("Test point contenu 1", ellipse.contient(coordB));
		assertTrue("Test point contenu 2", ellipse.contient(coordC));
		assertFalse("Test point non contenu", ellipse.contient(coordD));
		assertTrue("Test point contenu 3", ellipse.contient(coordE));
		
		
	}
	
	
	@Test
    public void testRemplissage() {
        Ellipse test = new Ellipse();
        assertFalse("Test la forme n'est pas remplie", test.estRempli());
        test.setRempli(true);
        assertTrue("Test la forme est remplie", test.estRempli());
    }

    @Test
    public void testGetCouleur() {
        Ellipse test = new Ellipse();
        assertEquals("Couleur par défaut", UIManager.getColor("Panel.foreground"), test.getCouleur());
    }

    @Test
    public void testSetCouleur() {
        Ellipse test = new Ellipse();
        test.setCouleur(Color.RED);
        assertEquals("Set de la couleur", Color.RED, test.getCouleur());
    }

    @Test
    public void testExceptionConstructor() {
        expectedException.expect(IllegalArgumentException.class);
        new Ellipse(new Coordonnees(2, 3), -50, 20);
        new Ellipse(new Coordonnees(2, 3), 50, -20);
    }

    @Test
    public void testSetHauteurException() {
        Ellipse ellipse = new Ellipse();
        expectedException.expect(IllegalArgumentException.class);
        ellipse.setHauteur(-50);
    }

    @Test
    public void testSetLargeurException() {
        Ellipse ellipse = new Ellipse();
        expectedException.expect(IllegalArgumentException.class);
        ellipse.setLargeur(-50);
    }

    

}
