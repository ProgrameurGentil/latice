package latice;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import latice.model.Tuile;
import latice.model.Type;
import latice.model.Case;
import latice.model.Constantes;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.PlateauTuiles;
import latice.model.PlateauDeCase;
import latice.model.Position;

public class LaticeJeuxEssais {
	public static void main(String[] args) {
		// test création des joueur + liste de joueur
		MaitreDuJeu leMaitre = new MaitreDuJeu();
		Joueur joueur1 = new Joueur("Premier");
		Joueur joueur2 = new Joueur("Second");
		ArrayList<Joueur> listeJoueurs = new ArrayList<>(Arrays.asList(joueur1, joueur2)); 
				
		Position end = new Position(0, 0);
		Position start = new Position(Constantes.COLONNES - 1, Constantes.LIGNES - 1);
		PlateauTuiles plateauTuiles = new PlateauTuiles(joueur1, joueur2);
		
		
		PlateauDeCase plateauDeCase = leMaitre.initPlateauCase();
		
	    // test initialisation des tuiles	
		ArrayList<Tuile> touteLesTuile = new ArrayList<Tuile>();
		touteLesTuile = leMaitre.initTuiles();
		
		if ( touteLesTuile.size() == 72) {
			System.out.println("tout va bien n°1  :  "+ touteLesTuile.size() +" = 72");
		} else {
			System.out.println("tout ne va pas bien n°1  :  "+ touteLesTuile.size() +" != 72");
		}
		
		if ( listeJoueurs.size() == 2) {
			System.out.println("tout va bien n°2  :  "+ listeJoueurs.size() +" = 2");
		} else {
			System.out.println("tout ne va pas bien n°2  :  "+ listeJoueurs.size() +" != 2");
		}
		
		// test création des pioche		
		leMaitre.diviserTuilesEnDeux(touteLesTuile, listeJoueurs);	
		if ( joueur1.pioche.taille() == 36 && joueur2.pioche.taille() == 36) {
			System.out.println("tout va bien n°3  :  "+ joueur1.pioche.taille() +" = 36 et "+ joueur2.pioche.taille() +" = 36");
		} else {
			System.out.println("tout ne va pas bien n°3  :  "+ joueur1.pioche.taille() +" != 36 et/ou "+ joueur2.pioche.taille() +" != 36");
		}
		
		// test création des rack
		
		//test remplisage des rack
		
		//plateau
		plateauDeCase.toString();
	}
}
