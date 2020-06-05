package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	private static final double EPSILON = 1e-3d;

	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testConstructeurParDefaut() {
		Cercle cercle = new Cercle();

		assertEquals("Test de la hauteur", Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(), cercle.getPosition());
	}

	@Test
	public void testConstructeurDimension() {
		Cercle cercle = new Cercle(50);

		assertEquals("Test de la hauteur", 50, cercle.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", 50, cercle.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(), cercle.getPosition());
	}

	@Test
	public void testConstructeurAll() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25), 50);

		assertEquals("Test de la hauteur", 50, cercle.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", 50, cercle.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(15, 25), cercle.getPosition());
	}

	@Test
	public void testConstructeurPosition() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25));

		assertEquals("Test de la hauteur", Forme.HAUTEUR_PAR_DEFAUT, cercle.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), EPSILON);
		assertEquals("Test de coordonnees", new Coordonnees(15, 25), cercle.getPosition());
	}

	@Test
	public void setHauteur() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25));

		cercle.setHauteur(40);
		assertEquals("Test de la hauteur", 40, cercle.getHauteur(), EPSILON);
		assertEquals("Test de la largeur (côté)", 40, cercle.getLargeur(), EPSILON);

	}

	@Test
	public void setLargeur() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25));
		cercle.setLargeur(40);
		assertEquals("Test de la largeur", 40, cercle.getLargeur(), EPSILON);
		assertEquals("Test de la hauteur (côté)", 40, cercle.getHauteur(), EPSILON);

	}

	@Test
	public void aire() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25), 50);

		assertEquals("Test de l'aire", 1963.495, cercle.aire(), EPSILON);

	}

	@Test
	public void perimetre() {
		Cercle cercle = new Cercle(new Coordonnees(15, 25), 50);

		assertEquals("Test du perimetre", 157.08, cercle.perimetre(), EPSILON);

	}

	@Test
	public void testToString() {
		Cercle cercle = new Cercle(new Coordonnees(122, 78), 50);

		assertEquals("Test du toString FR",
				"[Cercle] : pos (122,0 , 78,0) dim 50,0 x 50,0 périmètre : 157,08 aire : 1963,5 couleur = R51,V51,B51",
				cercle.toString());
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("Test du toString EN",
				"[Cercle] : pos (122.0 , 78.0) dim 50.0 x 50.0 périmètre : 157.08 aire : 1963.5 couleur = R51,G51,B51",
				cercle.toString());
		Locale.setDefault(Locale.FRENCH);

	}

	@Test
	public void contient() {
		Cercle cercle = new Cercle(new Coordonnees(9, 3), 6);
		Coordonnees coordB = new Coordonnees(12, 5);
		Coordonnees coordC = new Coordonnees(12, 3);
		Coordonnees coordD = new Coordonnees(11, 8);
		Coordonnees coordE = new Coordonnees(15, 6);
		Coordonnees coordF = new Coordonnees(14, 3);
		Coordonnees coordG = new Coordonnees(9, 10);

		assertTrue("Test point contenu 1", cercle.contient(coordB));
		assertTrue("Test point contenu 2", cercle.contient(coordC));
		assertTrue("Test point contenu 3", cercle.contient(coordD));
		assertTrue("Test point contenu 4", cercle.contient(coordE));
		assertFalse("Test point non contenu 1", cercle.contient(coordF));
		assertFalse("Test point non contenu 2", cercle.contient(coordG));

	}

	@Test
	public void testConstructorExceptionDiametreNegatif() {
		expectedException.expect(IllegalArgumentException.class);
		new Cercle(-20);
	}

	@Test
	public void testSetLargeurExceptionValeurNegative() {
		Cercle cercle = new Cercle();
		expectedException.expect(IllegalArgumentException.class);
		cercle.setLargeur(-12);
	}

	@Test
	public void testSetHauteurExceptionValeurNegative() {
		Cercle cercle = new Cercle();
		expectedException.expect(IllegalArgumentException.class);
		cercle.setHauteur(-14);
	}

}
