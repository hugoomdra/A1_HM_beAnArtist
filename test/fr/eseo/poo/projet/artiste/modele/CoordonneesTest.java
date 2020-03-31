package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoordonneesTest {

	double EPSILON = 1e-7d;

	@Test
	public void constructeur1() {

		Coordonnees coord = new Coordonnees();

		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, coord.getAbscisse(), EPSILON);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void constructeur2() {

		Coordonnees coord = new Coordonnees(20, 30);

		assertEquals(20, coord.getAbscisse(), EPSILON);
		assertEquals(30, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerVersHaut() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerVers(20, 20);

		assertEquals(20, coord.getAbscisse(), EPSILON);
		assertEquals(20, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerVersBas() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerVers(20, 40);

		assertEquals(20, coord.getAbscisse(), EPSILON);
		assertEquals(40, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerVersGauche() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerVers(15, 30);

		assertEquals(15, coord.getAbscisse(), EPSILON);
		assertEquals(30, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerVersDroite() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerVers(25, 30);

		assertEquals(25, coord.getAbscisse(), EPSILON);
		assertEquals(30, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerDeHaut() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerDe(0, -10);

		assertEquals(20, coord.getAbscisse(), EPSILON);
		assertEquals(20, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerDeBas() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerDe(0, 10);

		assertEquals(20, coord.getAbscisse(), EPSILON);
		assertEquals(40, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerDeGauche() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerDe(-10, 0);

		assertEquals(10, coord.getAbscisse(), EPSILON);
		assertEquals(30, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void deplacerDeDroite() {

		Coordonnees coord = new Coordonnees(20, 30);
		coord.deplacerDe(10, 0);

		assertEquals(30, coord.getAbscisse(), EPSILON);
		assertEquals(30, coord.getOrdonnee(), EPSILON);

	}

	@Test
	public void angleVersHaut() {

		Coordonnees coord = new Coordonnees();
		Coordonnees coordComparator = new Coordonnees(6, -4);

		assertEquals(-0.588, coord.angleVers(coordComparator), EPSILON);

	}

	@Test
	public void angleVersBas() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coordComparator = new Coordonnees(6, 4);

		assertEquals(0.588, coord.angleVers(coordComparator), EPSILON);
	}

	@Test
	public void distanceVersHaut() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coordComparator = new Coordonnees(0, 10);

		assertEquals(10, coord.distanceVers(coordComparator), EPSILON);
	}

	@Test
	public void distanceVersBas() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coordComparator = new Coordonnees(0, -10);

		assertEquals(10, coord.distanceVers(coordComparator), EPSILON);
	}

	@Test
	public void distanceVersGauche() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coordComparator = new Coordonnees(-20, 0);

		assertEquals(20, coord.distanceVers(coordComparator), EPSILON);
	}

	@Test
	public void distanceVersDroit() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coordComparator = new Coordonnees(30, 0);

		assertEquals(30, coord.distanceVers(coordComparator), EPSILON);
	}

	@Test
	public void distanceVersDiagonale() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coordComparator = new Coordonnees(6, 4);

		assertEquals(7.211, coord.distanceVers(coordComparator), EPSILON);

		coordComparator.deplacerVers(6, -4);
		assertEquals(7.211, coord.distanceVers(coordComparator), EPSILON);

		coordComparator.deplacerVers(-6, -4);
		assertEquals(7.211, coord.distanceVers(coordComparator), EPSILON);

		coordComparator.deplacerVers(-6, 4);
		assertEquals(7.211, coord.distanceVers(coordComparator), EPSILON);

	}

	@Test
	public void testToString() {

		
	}

}
