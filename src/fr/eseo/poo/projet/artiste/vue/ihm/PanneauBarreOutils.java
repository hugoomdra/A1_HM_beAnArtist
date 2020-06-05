package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class PanneauBarreOutils extends JPanel{
	
	private PanneauDessin panneauDessin;
	
	private SpinnerModel modelNbrBranche;
    private SpinnerModel modelTailleBranche;

	

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
		
		JToggleButton etoileButton = new JToggleButton(new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_ETOILE));
		etoileButton.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
		etoileButton.setText(ActionChoisirForme.NOM_ACTION_ETOILE);
		this.add(etoileButton);
		
		JToggleButton selectButton = new JToggleButton(new ActionSelectionner(panneauDessin));
		selectButton.setName(ActionSelectionner.NOM_ACTION);
		selectButton.setText(ActionSelectionner.NOM_ACTION);
		this.add(selectButton);
		
		JButton colorButton = new JButton(new ActionChoisirCouleur(panneauDessin));
		colorButton.setName(ActionChoisirCouleur.NOM_ACTION);
		colorButton.setText(ActionChoisirCouleur.NOM_ACTION);
		this.add(colorButton);
		

		JCheckBox remplissageCheckbox = new JCheckBox(new ActionChoisirRemplissage(panneauDessin));
		remplissageCheckbox.setName(ActionChoisirRemplissage.NOM_ACTION);
		remplissageCheckbox.setText(ActionChoisirRemplissage.NOM_ACTION);
		remplissageCheckbox.setSelected(getPanneauDessin().getModeRemplissage());
		this.add(remplissageCheckbox);
		
		
		groupOfButton.add(boutonEffacer);
		groupOfButton.add(ligneButton);
		groupOfButton.add(ellipseButton);
		groupOfButton.add(cercleButton);
		groupOfButton.add(selectButton);
		
		// Création de la sélection du nombre de branche de l'étoile
        JLabel texteNbrBranche = new JLabel("Nombre de branche");
        this.modelNbrBranche = new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1);
        JSpinner nbrBranche = new JSpinner(modelNbrBranche);
        nbrBranche.setName("Nombre de branche");
        this.add(texteNbrBranche);
        this.add(nbrBranche);

        // Création de la sélection de la taille des branches de l'étoile
        JLabel texteTailleBranche = new JLabel("Proportion des branches");
        this.modelTailleBranche = new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
                0.0, 1.0, 0.01);
        JSpinner tailleBranche = new JSpinner(modelTailleBranche);
        tailleBranche.setName("Proportion des branches");
        this.add(texteTailleBranche);
        this.add(tailleBranche);

		
	}

	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}

	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	
	public int getNbBranches() {
        return (int) this.modelNbrBranche.getValue();
    }

    public double getLongueurBranche() {
        return (double) this.modelTailleBranche.getValue();
    }

	
	
	
	
	
}
