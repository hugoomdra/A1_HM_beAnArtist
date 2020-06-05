package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme{

	private final PanneauBarreOutils tools;

    public OutilEtoile(PanneauBarreOutils tools) {
        this.tools = tools;
    }

	
	
	@Override
	protected VueForme creerVueForme() {
		
		double distance = this.getDebut().distanceVers(this.getFin()) * 2;
        double angle = this.getDebut().angleVers(this.getFin());
        int nbrBranche = this.tools.getNbBranches();
        double longBranche = this.tools.getLongueurBranche();
        double x = this.getFin().getAbscisse() - distance / 2;
        double y = this.getFin().getOrdonnee() - distance / 2;
        Etoile etoile = new Etoile(new Coordonnees(x, y), distance, nbrBranche, angle, longBranche);
        etoile.setCouleur(this.getPanneauDessin().getCouleurCourante());
        etoile.setRempli(this.getPanneauDessin().getModeRemplissage());
        System.out.println(etoile);
        return new VueEtoile(etoile);

		
	}
	
}
