package latice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import latice.model.Constantes;
import latice.model.Couleur;
import latice.model.Forme;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Position;
import latice.model.Rack;
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
		Position positionTps = Position.position(1);
		System.out.println(positionTps.toString());
		positionTps = Position.position(81);
		System.out.println(positionTps.toString());
		positionTps = Position.position(-1);
		System.out.println(positionTps.toString());
		positionTps = Position.position(82);
		System.out.println(positionTps.toString());
		
		// testes rack
		// poser
		boolean rep = true;
		Tuile T1a = new Tuile(Couleur.ROUGE, Forme.OISEAU);
		Tuile T1b = new Tuile(Couleur.BLEU, Forme.OISEAU);
		Tuile T1c = new Tuile(Couleur.JAUNE, Forme.FLEUR);
		Tuile T1d = new Tuile(Couleur.VERT, Forme.DAUPHIN);
		Tuile T1e = new Tuile(Couleur.ROUGE, Forme.TORTUE);
		List<Tuile> lerack1 = new ArrayList<>(Arrays.asList(T1a, T1b, T1c, T1d, T1e));
		Rack rackUn = new Rack(lerack1);
		
		Tuile T2a = new Tuile(Couleur.BLEU, Forme.FLEUR);
		Tuile T2b = new Tuile(Couleur.JAUNE, Forme.PLUME);
		Tuile T2c = new Tuile(Couleur.JAUNE, Forme.PLUME);
		Tuile T2d = new Tuile(Couleur.ROUGE, Forme.DAUPHIN);
		Tuile T2e = new Tuile(Couleur.VERT, Forme.TORTUE);
		List<Tuile> lerack2 = new ArrayList<>(Arrays.asList(T2a, T2b, T2c, T2d, T2e));
		Rack rackDeux = new Rack(lerack2);
		
		Joueur joueurTestRack1 = new Joueur("J1", 0, 0, 0, rackUn, joueur1.pioche ) ;
		Joueur joueurTestRack2 = new Joueur("J2", 0, 0, 0, rackDeux, joueur2.pioche ) ;
		joueurTestRack1.getRack().afficher();
		plateauTuiles.poser(new Position(4,4), new Tuile(Couleur.BLEU,Forme.DAUPHIN));
		rep = joueurTestRack1.poserTuile(3, 40, plateauDeCase, plateauTuiles);
		joueurTestRack1.getRack().afficher();
		
		rep = joueurTestRack2.poserTuile(3, 40, plateauDeCase, plateauTuiles);
		System.out.println(rep);
		joueurTestRack2.getRack().afficher();
		rep = joueurTestRack2.poserTuile(2, 31, plateauDeCase, plateauTuiles);
		System.out.println(rep);
		joueurTestRack2.getRack().afficher();
		
		//remplir
		System.out.println(joueurTestRack1.pioche.taille()+" , "+joueurTestRack1.getRack().taille());
		joueurTestRack1.RemplirSonRack();
		System.out.println(joueurTestRack1.pioche.taille()+" , "+joueurTestRack1.getRack().taille());
		
		//echanger
		joueurTestRack2.getRack().afficher();
		
		joueurTestRack2.echangerRack();
		joueurTestRack2.getRack().afficher();
		
		//acheter un tour
		joueurTestRack1.setPoints(5);
		System.out.println(joueurTestRack1.getPoints()+" , "+joueurTestRack1.getNombreActionRestanteAJouer());
		joueurTestRack1.acheterAction();
		System.out.println(joueurTestRack1.getPoints()+" , "+joueurTestRack1.getNombreActionRestanteAJouer());
	}
}
