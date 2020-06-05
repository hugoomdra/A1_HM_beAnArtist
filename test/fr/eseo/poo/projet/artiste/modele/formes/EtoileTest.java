package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EtoileTest {

	
	private static final double EPSILON = 1e-3d;
	
	@Rule
    public final ExpectedException expectedException = ExpectedException.none();

	
	@Test
	public void testConstructeurAll() {
		Etoile etoile = new Etoile(new Coordonnees(20, 10), 5, 4, 0, 0.75);
		
		assertEquals("Test de la hauteur", 5, etoile.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", 5, etoile.getHauteur(), EPSILON);
		assertEquals("Test du nombre de branches", 4, etoile.getNombreBranches(), EPSILON);
		assertEquals("Test du nombre de sommets", 8, etoile.getCoordonnees().size());
		assertEquals("Test de la longueur des branches", 0.75, etoile.getLongueurBranche(), EPSILON);
		assertFalse("Test mode remplissage", etoile.estRempli());
		
		List<Coordonnees> listeReelPoints = new ArrayList<Coordonnees>();
		listeReelPoints.add(new Coordonnees(25.0, 12.5));
		listeReelPoints.add(new Coordonnees(22.94, 12.06));
		listeReelPoints.add(new Coordonnees(22.5 , 10.0));
		listeReelPoints.add(new Coordonnees(22.06, 12.06));
		listeReelPoints.add(new Coordonnees(20.0, 12.5));
		listeReelPoints.add(new Coordonnees(22.06, 12.94));
		listeReelPoints.add(new Coordonnees(22.5, 15.0));
		listeReelPoints.add(new Coordonnees(22.94,  12.94));
		
		System.out.println(etoile.getCoordonnees());
		
		for(int i = 0; i < etoile.getCoordonnees().size(); i++) {
			assertEquals("Test du Point "+ i, listeReelPoints.get(i), etoile.getCoordonnees().get(i));	
		}
		
	}
	
	@Test
	public void testConstructeurPosition() {
		Etoile etoile = new Etoile(new Coordonnees(20, 10), 5, 4, 0, 0.75);
		
		assertEquals("Test de la position", new Coordonnees(20, 10), etoile.getPosition());
		
		
	}
	
	@Test
	public void testConstructeurDimension() {
		Etoile etoile = new Etoile(20);
		
		assertEquals("Test de la hauteur", 20, etoile.getHauteur(), EPSILON);
		assertEquals("Test de la largeur", 20, etoile.getLargeur(), EPSILON);

		
	}
	
	@Test
	public void testConstructeurParDefaut() {
		Etoile etoile = new Etoile();
		
		assertEquals("Test du nombre de branche par défaut", Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, etoile.getNombreBranches());
        assertEquals("Test de l'Angle par défaut", Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
        		etoile.getAnglePremiereBranche(), EPSILON);
        assertEquals("Test de la longueur branche par défaut", Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
        		etoile.getLongueurBranche(), EPSILON);

		
	}
	
	@Test
	public void aireTest() {
		Etoile etoile = new Etoile(new Coordonnees(20, 10), 5, 4, 0, 0.75);
		
		assertEquals("Test de l'Aire", 4.42, etoile.aire(), EPSILON);
	}
	
	@Test
	public void perimetreTest() {
		Etoile etoile = new Etoile(new Coordonnees(20, 10), 5, 4, 0, 0.75);
		
		assertEquals("Test du Périmètre", 16.84, etoile.perimetre(), EPSILON);
	}
	
	@Test
	public void contiensTest() {
		Etoile etoile = new Etoile(new Coordonnees(20, 10), 5, 4, 0, 0.75);
		
		assertFalse("Test du contiens", etoile.contient(new Coordonnees(1, 1)));
	}
	
	
	@Test
    public void testExceptionAngle() {
        expectedException.expect(IllegalArgumentException.class);
        new Etoile(new Coordonnees(2, 5), 5, 5,
                10, 0.5);
    }

    @Test
    public void testExceptionTaille() {
        expectedException.expect(IllegalArgumentException.class);
        new Etoile(new Coordonnees(2, 5), -5, 5,
                0, 0.5);
    }

    @Test
    public void testExceptionNombreBranche() {
        expectedException.expect(IllegalArgumentException.class);
        new Etoile(new Coordonnees(2, 5), 2, 0,
                0, 0.5);
        new Etoile(new Coordonnees(2, 5), 2, 200,
                0, 0.5);
    }

    @Test
    public void testExceptionLongueurBranche() {
        expectedException.expect(IllegalArgumentException.class);
        new Etoile(new Coordonnees(2, 5), 2, 4,
                0, -2);
        new Etoile(new Coordonnees(2, 5), 2, 4,
                0, 2);
    }



	
	

	
	
	
}
