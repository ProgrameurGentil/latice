package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import latice.model.*;

public class TestGestionDesTuiles {
	MaitreDuJeu maitre = new MaitreDuJeu();
	ArrayList<Tuile> listeDeTuiles = new ArrayList<Tuile>();
	
	@BeforeEach
	public void ajouterDesElementDansLaListePourFaireLesTests() {
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.DOPHIN));
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.DOPHIN));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.DOPHIN));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.GRIS, Forme.DOPHIN));
		listeDeTuiles.add(new Tuile(Couleur.GRIS, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.DOPHIN));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.FLEUR));
	}
	@Test
	public void diviserUneListeDeTuillesEnDeuxEtAvoirUneSeparationJuste() {
		ArrayList<Tuile> listeDeTuiles1 = new ArrayList<Tuile>();
		
		ArrayList<Tuile> listeDeTuilesDeVerif = new ArrayList<Tuile>();
		listeDeTuilesDeVerif.add(new Tuile(Couleur.BLEU, Forme.DOPHIN));
		listeDeTuilesDeVerif.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		listeDeTuilesDeVerif.add(new Tuile(Couleur.ROUGE, Forme.DOPHIN));
		listeDeTuilesDeVerif.add(new Tuile(Couleur.ROUGE, Forme.FLEUR));
		listeDeTuilesDeVerif.add(new Tuile(Couleur.VERT, Forme.DOPHIN));
		
		maitre.diviserTuilesEnDeux(listeDeTuiles, listeDeTuiles1, new ArrayList<Tuile>());
		System.out.println(listeDeTuiles1);
		System.out.println(listeDeTuilesDeVerif);
		
		assertEquals(listeDeTuiles1.get(0), listeDeTuilesDeVerif.get(0));
		assertEquals(listeDeTuiles1.get(1), listeDeTuilesDeVerif.get(1));
		assertEquals(listeDeTuiles1.get(2), listeDeTuilesDeVerif.get(2));
		assertEquals(listeDeTuiles1.get(3), listeDeTuilesDeVerif.get(3));
		assertEquals(listeDeTuiles1.get(4), listeDeTuilesDeVerif.get(4));
	}
	
	@Test
	public void melangerUnePiche() {
		ArrayList<Tuile> tuilesMelange = listeDeTuiles;
		maitre.melangerTuiles(listeDeTuiles);
		
		assertEquals(tuilesMelange.size(), listeDeTuiles.size());
		assertFalse( listeDeTuiles.get(0).equals(tuilesMelange.get(0)) && listeDeTuiles.get(1).equals(tuilesMelange.get(1)) );
	}
}
