package latice.application;

import java.util.ArrayList;
import java.util.List;

import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Tuile;

public class LaticeMain {

	public  void main(String[] args) {
		final MaitreDuJeu maitreDuJeu = new MaitreDuJeu();
		final Pioche toutesLesTuiles = Tuile.initialisationTuiles();
		List<Joueur> listeDeJoueurs = new ArrayList<Joueur>();
		PlateauDeCase plateauDeCase = new PlateauDeCase();
		PlateauTuiles plateauDeTuiles = new PlateauTuiles();
		
		listeDeJoueurs.add(new Joueur("Joueur 1"));
		listeDeJoueurs.add(new Joueur("Joueur 2"));
		
		maitreDuJeu.diviseEtRepartiLesTuilesEnPioches(toutesLesTuiles, listeDeJoueurs);
		
		for (Joueur joueur : listeDeJoueurs) {
			joueur.remplirSonRack();
		}
	}
	
}
