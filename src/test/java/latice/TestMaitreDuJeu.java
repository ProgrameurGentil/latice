package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import latice.model.Couleur;
import latice.model.Forme;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.Rack;
import latice.model.Tuile;

public class TestMaitreDuJeu {
	private static List<Joueur> listeDeJoueurs = new ArrayList<Joueur>();
	public static final Integer nbToursMax = 10;
	private static final MaitreDuJeu maitreDuJeu = new MaitreDuJeu();
	
	@BeforeAll
	public void initialisation() {
		Pioche toutesLesTuiles = Tuile.initialisationTuiles();
		listeDeJoueurs.add(new Joueur("Joueur 1"));
		listeDeJoueurs.add(new Joueur("Joueur 2"));
		
		maitreDuJeu.diviseEtRepartiLesTuilesEnPioches(toutesLesTuiles, listeDeJoueurs);
	}
	
	@Test
	public void diviserUnPiocheDeFaconEgal() {
		assertEquals(listeDeJoueurs.get(0).getPioche().taille(), listeDeJoueurs.get(1).getPioche().taille());
	}
	
	@Test
	public void testSiLaFonctionDeChoixDuJoueurAléatoireAvecSonIndiceFonctionne() {
		assertTrue(maitreDuJeu.quelJoueurCommence(listeDeJoueurs) < listeDeJoueurs.size());
		assertTrue(maitreDuJeu.quelJoueurCommence(listeDeJoueurs) < listeDeJoueurs.size());
		assertTrue(maitreDuJeu.quelJoueurCommence(listeDeJoueurs) < listeDeJoueurs.size());
	}
	
	@Test
	public void unJoueurNAPlusDeTuiles() {
		listeDeJoueurs.get(0).setPioche(new Pioche());
		listeDeJoueurs.get(0).setRack(new Rack());
		assertTrue(maitreDuJeu.estCeQunJoueurAPLusDeTuiles(listeDeJoueurs));
	}
	
	@Test
	public void aucunJoueurNAPlusDeTuiles() {
		listeDeJoueurs.get(0).setPioche(new Pioche());
		listeDeJoueurs.get(0).setRack(new Rack());
		assertFalse(maitreDuJeu.estCeQunJoueurAPLusDeTuiles(listeDeJoueurs));
	}
	
	@Test
	public void leJoueur1NAPlusDeTuiles() {
		listeDeJoueurs.get(0).setPioche(new Pioche());
		listeDeJoueurs.get(0).setRack(new Rack());
		assertEquals(maitreDuJeu.quelJoueurAPlusDeTuiles(listeDeJoueurs), listeDeJoueurs.get(0));
	}
	
	@Test
	public void leJoueur2NAPlusDeTuiles() {
		listeDeJoueurs.get(1).setPioche(new Pioche());
		listeDeJoueurs.get(1).setRack(new Rack());
		assertEquals(maitreDuJeu.quelJoueurAPlusDeTuiles(listeDeJoueurs), listeDeJoueurs.get(2));
	}
	
	@Test
	public void toutLesJoueursOntDesTuiles() {
		assertNull(maitreDuJeu.quelJoueurAPlusDeTuiles(listeDeJoueurs));
	}
	
	public void leJoueur1ALeMoinsDeTuiles(List<Joueur> listedeJoueurs) {
		
		listeDeJoueurs.get(0).getPioche().enlever(1);
		assertEquals(maitreDuJeu.quelJoueurALeMoinsDeTuiles(listeDeJoueurs), listeDeJoueurs.get(0));
	}
}
