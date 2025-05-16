package latice.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Tuile;

public class LaticeJeuxEssais {

	private static final String LINE_BAR = "----------------------";
	private static final String LINE_BAR_TITLE = "#-----------------------#";

	public static void main(String[] args) {
		System.out.println(titre());
		
		MaitreDuJeu maitreDuJeu = new MaitreDuJeu();
		
		List<Tuile> touteLesTuile = new ArrayList<Tuile>();
		touteLesTuile = maitreDuJeu.initialisationTuiles();
		
		System.out.println("Nb total de tuiles : " + touteLesTuile.size());
		
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>( 
											Arrays.asList(new Joueur("Joueur 1"), new Joueur("Joueur 2")));
		maitreDuJeu.diviseEtRepartiLesTuilesEnPioches(touteLesTuile, listeJoueur);
		
		System.out.println(LINE_BAR);
		System.out.println("Taille du rack du joueur 1 : " + listeJoueur.get(0).pioche.taille());
		System.out.println("Taille du rack du joueur 2 : " + listeJoueur.get(1).pioche.taille());
		
		for (Joueur joueur : listeJoueur) {
			//Pioche p = joueur.getPioche();
			//System.out.println("Pioche : " + p);
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
		
		System.out.println(LINE_BAR);
		System.out.println("Taille du rack du joueur 1 : " + listeJoueur.get(0).pioche.taille());
		System.out.println("Taille du rack du joueur 2 : " + listeJoueur.get(1).pioche.taille());
	}
	
	private static String titre() {
		return LINE_BAR_TITLE + "\nLatice Jeux Essais (brut)\n" + LINE_BAR_TITLE + "\n";
	}

}
