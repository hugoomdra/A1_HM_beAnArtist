package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;

public class PanneauBarreOutils extends JPanel{
	
	private PanneauDessin panneauDessin;

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		setPanneauDessin(panneauDessin);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
		
	}
	
	public void initComponents() {
		
		ActionEffacer actionEffacer = new ActionEffacer(getPanneauDessin());
		JButton boutonEffacer = new JButton(actionEffacer);
		boutonEffacer.setName(actionEffacer.NOM_ACTION);
		this.add(boutonEffacer);
		
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	
	
	
	
	
	
}
