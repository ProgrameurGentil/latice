package latice.application;

import java.util.ArrayList;
import java.util.Arrays;

import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.Tuile;

public class LaticeJeuxEssais {

	private static final String LINE_BAR = "----------------------";

	public static void main(String[] args) {
		MaitreDuJeu maitreDuJeu = new MaitreDuJeu();
		
		ArrayList<Tuile> touteLesTuile = new ArrayList<Tuile>();
		touteLesTuile = maitreDuJeu.initTuiles();
		
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>( 
											Arrays.asList(new Joueur("Joueur 1"), new Joueur("Joueur 2")));
		maitreDuJeu.diviserTuilesEnDeux(touteLesTuile, listeJoueur);
		
		for (Joueur joueur : listeJoueur) {
			Pioche p = joueur.getPioche();
			System.out.println("Pioche : " + p.taille());
			maitreDuJeu.piocher5Tuiles(joueur.getPioche(), joueur.getRack());
		}
		
		System.out.println(LINE_BAR);
		System.out.println("Joueur 1 :");
		System.out.println("Rack :");
		listeJoueur.get(0).getRack().afficher();
		
		System.out.println(LINE_BAR);
		System.out.println("Joueur 2 :");
		System.out.println("Rack :");
		listeJoueur.get(1).getRack().afficher();
	}

}
