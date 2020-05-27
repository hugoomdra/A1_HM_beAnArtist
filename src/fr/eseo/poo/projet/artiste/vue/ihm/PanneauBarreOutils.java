package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;

public class PanneauBarreOutils extends JPanel{
	
	private PanneauDessin panneauDessin;

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		setPanneauDessin(panneauDessin);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
		
	}

	
	public void initComponents() {
		
		
		ButtonGroup groupOfButton = new ButtonGroup();
		
		ActionEffacer actionEffacer = new ActionEffacer(getPanneauDessin());
		JButton boutonEffacer = new JButton(actionEffacer);
		boutonEffacer.setName(ActionEffacer.NOM_ACTION);
		this.add(boutonEffacer);
		
		
		JToggleButton ligneButton = new JToggleButton(new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
		ligneButton.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		ligneButton.setText(ActionChoisirForme.NOM_ACTION_LIGNE);
		this.add(ligneButton);
		
		JToggleButton ellipseButton = new JToggleButton(new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		ellipseButton.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ellipseButton.setText(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		this.add(ellipseButton);
		
		JToggleButton cercleButton = new JToggleButton(new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
		cercleButton.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		cercleButton.setText(ActionChoisirForme.NOM_ACTION_CERCLE);
		this.add(cercleButton);
		
		JToggleButton selectButton = new JToggleButton(new ActionSelectionner(panneauDessin));
		selectButton.setName(ActionSelectionner.NOM_ACTION);
		selectButton.setText(ActionSelectionner.NOM_ACTION);
		this.add(selectButton);
		
		JButton colorButton = new JButton(new ActionChoisirCouleur(panneauDessin));
		colorButton.setName(ActionChoisirCouleur.NOM_ACTION);
		colorButton.setText(ActionChoisirCouleur.NOM_ACTION);
		this.add(colorButton);
		
		
		
		groupOfButton.add(boutonEffacer);
		groupOfButton.add(ligneButton);
		groupOfButton.add(ellipseButton);
		groupOfButton.add(cercleButton);
		groupOfButton.add(selectButton);
		
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	
	
	
	
	
	
}
