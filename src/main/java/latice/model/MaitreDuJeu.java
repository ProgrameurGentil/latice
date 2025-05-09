package latice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MaitreDuJeu {
	private Integer nb_tours;
	
	public Boolean gagner(Joueur joueur) {
		//TODO fonction qui retourne un boolean en si le joueur mit en parametre est gagnant
		return null;
	}
	public void lancerTour() {
		//TODO fonction qui lance un tour
	}
	public Joueur quelJoueurDoitJouer() {
		//TODO fonction qui retourne le joueur qui doit jouer
		return null;	
	}
	
	public List<Tuile> initTuiles() {
		List<Tuile> touteLesTuile = new ArrayList<Tuile>();
		
		for (Couleur couleur : Couleur.values()) {
			for (Forme forme : Forme.values()) {
				for (int count=0;count<2;count++) {
					touteLesTuile.add(new Tuile(couleur, forme));
				}
	        }
		}
		return touteLesTuile;
	}
	
	public void melangerTuiles(GroupeDeTuile tuiles){
		tuiles.melanger();
	}
	
	public void diviserTuilesEnDeux(List<Tuile> tuiles, List<Joueur> listeJoueurs) {	
 		Collections.shuffle(tuiles);
	    int taille = tuiles.size();
	    int dividende = listeJoueurs.size();
	    int debutDePioche = 0;

	    for (int i = 0; i < listeJoueurs.size(); i++) {
	        int finDePioche = debutDePioche + (taille / dividende);
	        ArrayList<Tuile> piocheJoueur = new ArrayList<>(tuiles.subList(debutDePioche, finDePioche));
	        listeJoueurs.get(i).setPioche(new Pioche(piocheJoueur));
	        debutDePioche = finDePioche;
	    }
	}

	public void piocher5Tuiles(Pioche pioche, Rack rack) {

		Integer taillePioche = pioche.taille();
		Integer tailleRack = rack.taille();
		Integer i = 0;
		while (i < 5 && taillePioche > 0 && tailleRack < 5) {
			rack.ajouter(pioche.enlever(0)); // peut avoir une erreur si le l'indice n'est pas trouvé
			taillePioche--;
			tailleRack++;
            i++;
		}
	}
	
	public PlateauDeCase initPlateauCase() {
		PlateauDeCase plateau = new PlateauDeCase();
		
		int i;
		int j;
		Position position;
		for (i=0;i<Constantes.COLONNES;i++) {
			for (j=0;j<Constantes.LIGNES;j++) {
				position = new Position(i,j);
				plateau.cases().put(position, new Case(Type.NORMAL));
				boolean res = plateau.cases().containsKey(position);
				if(res) {
					String ss = "e";
				}
			}
		}
		
		for (Position positionSun : Constantes.POSITION_SOLEIL) {
			plateau.cases().replace(positionSun, new Case(Type.SOLEIL, null));
		}
	plateau.cases().replace(Constantes.CENTRE, new Case(Type.LUNE, null));
		
		return plateau;
	}
}

