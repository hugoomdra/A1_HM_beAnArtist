package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		assertEquals("[Ellipse] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 63,82 aire : 294,52", ellipse.toString());
	}

}
