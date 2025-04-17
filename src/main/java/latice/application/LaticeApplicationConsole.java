package latice.application;

import java.util.ArrayList;

import latice.model.*;

public class LaticeApplicationConsole {
	private static final String LINE_BAR = "-----------------------------------------------------";
	
	public static void main(String[] args) {
		System.out.println(LINE_BAR);
		System.out.println("-- Bienvenue dans notre magnifique jeu de latice ! --");
		System.out.println("-- Développé par Henzo                             --");
		System.out.println("-- Et par Evan                                     --");
		System.out.println("-- Et par Adam                                     --");
		System.out.println(LINE_BAR);
		
		/*ArrayList<Tuile> TouteLesTuile = new ArrayList<Tuile>();
		for (int count=0;count<2;count++) {
			for (Couleur couleur : Couleur.values()) {
				for (Forme forme : Forme.values()) {
					TouteLesTuile.add(new Tuile(couleur, forme));
				}
	        }
		}
		int x=0;
		for (Tuile tuile : TouteLesTuile) {
			System.out.println(tuile);
			x++;			
		}
		System.out.println(x);
		*/

	}

}