package latice;

import java.util.ArrayList;

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
		// test création des pioche
		leMaitre.diviserTuilesEnDeux(touteLesTuile, null);
		
		// test création des rack
		Joueur joueur1 = new Joueur("premier", pioche1);
		
		//test remplisage des rack
		
	}
}
