package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements MouseInputListener{

	
	private Coordonnees debut;
	private Coordonnees fin;
	private PanneauDessin panneauDessin;
	
	
	
	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}
	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	public Coordonnees getDebut() {
		return debut;
	}
	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}
	public Coordonnees getFin() {
		return fin;
	}
	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		setDebut(new Coordonnees(x, y));
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		setFin(new Coordonnees(x, y));
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
