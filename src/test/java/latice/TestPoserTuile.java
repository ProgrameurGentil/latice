package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.model.Couleur;
import latice.model.Forme;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.Rack;
import latice.model.Tuile;

public class TestPoserTuile {
  MaitreDuJeu leMaitre = new MaitreDuJeu();
  PlateauTuiles plateauTuiles = new PlateauTuiles();
  Pioche touteLesTuile = new Pioche();
  
  @BeforeEach
	public void initialisation() {
  	PlateauDeCase plateauDeCase = PlateauDeCase.initialisationPlateauCase();
  	touteLesTuile = Tuile.initialisationTuiles();
    
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
  		
    Joueur joueurTest1 = new Joueur("J1", rackUn, new Pioche() ) ;
    Joueur joueurTest2 = new Joueur("J2", rackDeux, new ¨Pioche() ) ;
    ArrayList<Joueur> listeJoueurs = new ArrayList<>(Arrays.asList(joueurTest1, joueurTest2)); 
  
    leMaitre.diviseEtRepartiLesTuilesEnPioches(touteLesTuile, listeJoueurs);
  }

  @test
  
}
