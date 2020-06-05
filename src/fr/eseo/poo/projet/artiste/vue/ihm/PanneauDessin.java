package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends JPanel{

	public static final int LARGEUR_PAR_DEFAUT = 800;
	public static final int HAUTEUR_PAR_DEFAUT = 480;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.white;
	private Outil outilCourant;
	private Color couleurCourante;
	private boolean modeRemplissage;
	
	private final List<VueForme> vueFormes = new ArrayList<VueForme>();
	
	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
		
	}
	

	public PanneauDessin(int largeur, int hauteur, Color fond) {
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setBackground(fond);
		this.setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
		this.setModeRemplissage(false);
	}
	
	public List<VueForme> getVueFormes(){
		return this.vueFormes;
	}
	
	public void ajouterVueForme(VueForme vueForme) {
		getVueFormes().add(vueForme);
		System.out.println(this.getVueFormes().size());

	
	}
	
	protected void paintComponent(Graphics g2d) {
	
		super.paintComponent(g2d);
		
		Graphics2D g2D = (Graphics2D)g2d.create();
	
		getVueFormes().forEach((f) -> f.affiche(g2D));
		
		g2D.dispose();
		
	}
	
	
	public void associerOutil(Outil outil) {
	
		if (getOutilCourant() != outil) {
			dissocierOutil();	
			setOutilCourant(outil);
			outil.setPanneauDessin(this);
			addMouseListener(outil);
			addMouseMotionListener(outil);
		}
	
		
	}
	
	private void dissocierOutil() {
	
		if (getOutilCourant() != null) {
			removeMouseMotionListener(getOutilCourant());
			removeMouseListener(getOutilCourant());
			getOutilCourant().setPanneauDessin(null);
			setOutilCourant(null);
		}
		
	}

	public Outil getOutilCourant() {
		return outilCourant;
	}

	private void setOutilCourant(Outil outilCourant) {
		this.outilCourant = outilCourant;
	}

	public Color getCouleurCourante() {
		return couleurCourante;
	}

	public void setCouleurCourante(Color couleurCourante) {
		this.couleurCourante = couleurCourante;
	}


	public boolean getModeRemplissage() {
		return modeRemplissage;
	}


	public void setModeRemplissage(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;
	}	
	
	
	
}
