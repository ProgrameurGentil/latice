package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import latice.model.*;

public class TestGestionDesTuiles {
	MaitreDuJeu maitre = new MaitreDuJeu();
	ArrayList<Tuile> listeDeTuiles = new ArrayList<Tuile>();
	ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	
	@BeforeEach
	public void ajouterDesElementDansLaListePourFaireLesTests() {
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.GRIS, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.GRIS, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.FLEUR));
		
		listeJoueur.add(new Joueur("J1"));
		listeJoueur.add(new Joueur("J2"));
	}
	@Test
	public void diviserUneListeDeTuillesEnDeuxEtAvoirUneSeparationJuste() {
		maitre.diviseEtRepartiLesTuilesEnPioches(listeDeTuiles, listeJoueur);
		
		assertEquals(listeJoueur.get(0).pioche.taille(), listeJoueur.get(1).pioche.taille());
	}
	
	@Test
	public void initialisationsDesTuilesEtVerificationDeLaTaille() {
		List<Tuile> listeDeTouteLesTuiles = maitre.initTuiles();
		assertEquals(listeDeTouteLesTuiles.size(), 72);
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
