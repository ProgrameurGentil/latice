package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.model.Couleur;
import latice.model.Forme;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.Tuile;

public class TestGestionDesTuiles {
	MaitreDuJeu maitre = new MaitreDuJeu();
	List<Tuile> listeDeTuiles= new ArrayList<Tuile>();
	ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	Pioche lesTuiles;
	
	@BeforeEach
	public void ajouterDesElementDansLaListePourFaireLesTests() {
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.BLEU_FONCE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.BLEU_FONCE, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.FLEUR));
		lesTuiles = new Pioche(listeDeTuiles); 
		
		listeJoueur.add(new Joueur("J1"));
		listeJoueur.add(new Joueur("J2"));
	}
	@Test
	public void diviserUneListeDeTuillesEnDeuxEtAvoirUneSeparationJuste() {
		maitre.diviseEtRepartiLesTuilesEnPioches(lesTuiles, listeJoueur);
		
		assertEquals(listeJoueur.get(0).getPioche().taille(), listeJoueur.get(1).getPioche().taille());
	}
	
	@Test
	public void initialisationsDesTuilesEtVerificationDeLaTaille() {
		Pioche listeDeTouteLesTuiles = Tuile.initialisationTuiles();
		assertEquals(listeDeTouteLesTuiles.taille(), 72);
	}
	
	@Test
	public void melangerUnGoupeDeTuile() {
		//TODO
	}
	
	/*
	@Test
	public void melangerUnePiche() {
		ArrayList<Tuile> tuilesMelange = listeDeTuiles;
		maitre.melangerTuiles(listeDeTuiles);
		
		assertEquals(tuilesMelange.size(), listeDeTuiles.size());
		assertFalse( listeDeTuiles.get(0).equals(tuilesMelange.get(0)) && listeDeTuiles.get(1).equals(tuilesMelange.get(1)) );
	}*/
}
