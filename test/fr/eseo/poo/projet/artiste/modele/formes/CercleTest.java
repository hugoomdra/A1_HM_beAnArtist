package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	@Test
	public void testToString() {
		Cercle cercle = new Cercle(new Coordonnees(10, 10), 25);
		
		assertEquals("[Ellipse] : pos (10,0 , 10,0) dim 25,0 x 25,0 périmètre : 78,54 aire : 490,87", cercle.toString());
	}

}
