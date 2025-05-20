package latice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import latice.model.Constantes;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Position;
import latice.model.Tuile;

public class LaticeJeuxEssais {
	public static void main(String[] args) {
		// test création des joueur + liste de joueur
		MaitreDuJeu leMaitre = new MaitreDuJeu();
		Joueur joueur1 = new Joueur("Premier");
		Joueur joueur2 = new Joueur("Second");
		ArrayList<Joueur> listeJoueurs = new ArrayList<>(Arrays.asList(joueur1, joueur2)); 
				
		Position start = new Position(0, 0);
		Position end = new Position(Constantes.COLONNES - 1, Constantes.LIGNES - 1);
		PlateauTuiles plateauTuiles = new PlateauTuiles();
		
		
		PlateauDeCase plateauDeCase = PlateauDeCase.initialisationPlateauCase();
		
	    // test initialisation des tuiles	
		Pioche touteLesTuile = new Pioche();
		touteLesTuile = Tuile.initialisationTuiles();
		
		if ( touteLesTuile.taille() == 72) {
			System.out.println("tout va bien n°1  :  "+ touteLesTuile.taille()+" = 72");
		} else {
			System.out.println("tout ne va pas bien n°1  :  "+ touteLesTuile.taille() +" != 72");
		}
		
		if ( listeJoueurs.size() == 2) {
			System.out.println("tout va bien n°2  :  "+ listeJoueurs.size() +" = 2");
		} else {
			System.out.println("tout ne va pas bien n°2  :  "+ listeJoueurs.size() +" != 2");
		}
		
		// test création des pioche		
		leMaitre.diviseEtRepartiLesTuilesEnPioches(touteLesTuile, listeJoueurs);	
		if ( joueur1.pioche.taille() == 36 && joueur2.pioche.taille() == 36) {
			System.out.println("tout va bien n°3  :  "+ joueur1.pioche.taille() +" = 36 et "+ joueur2.pioche.taille() +" = 36");
		} else {
			System.out.println("tout ne va pas bien n°3  :  "+ joueur1.pioche.taille() +" != 36 et/ou "+ joueur2.pioche.taille() +" != 36");
		}
		
		// test création des rack
		
		//test remplisage des rack
		
		//plateau
		plateauDeCase.toString();
		
		//test PDC position()
		Position positionTps = plateauDeCase.position(1);
		System.out.println(positionTps.toString());
		positionTps = plateauDeCase.position(81);
		System.out.println(positionTps.toString());
		positionTps = plateauDeCase.position(-1);
		System.out.println(positionTps.toString());
		positionTps = plateauDeCase.position(82);
		System.out.println(positionTps.toString());
	}
}
