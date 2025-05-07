package latice;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import latice.model.Tuile;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;

public class LaticeJeuxEssais {
	public static void main(String[] args) {
	    // test initialisation des tuiles	
		MaitreDuJeu leMaitre = new MaitreDuJeu();
		ArrayList<Tuile> touteLesTuile = new ArrayList<Tuile>();
		touteLesTuile = leMaitre.initTuiles();
		if ( touteLesTuile.size() == 72) {
			System.out.println("tout va bien n°1  :  "+ touteLesTuile.size() +" = 72");
		} else {
			System.out.println("tout ne va pas bien n°1  :  "+ touteLesTuile.size() +" != 72");
		}
		// test création des joueur + liste de joueur
		Joueur joueur1 = new Joueur("Premier");
		Joueur joueur2 = new Joueur("Second");
		ArrayList<Joueur> listeJoueurs = new ArrayList<>(Arrays.asList(joueur1, joueur2));
		// test création des pioche		
		leMaitre.diviserTuilesEnDeux(touteLesTuile, listeJoueurs);	
		// test création des rack
		
		//test remplisage des rack
		
	}
}
