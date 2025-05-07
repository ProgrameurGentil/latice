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
		
	}
}
