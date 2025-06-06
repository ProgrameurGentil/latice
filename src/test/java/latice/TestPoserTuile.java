package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

public class TestPoserTuile {
	MaitreDuJeu leMaitre = new MaitreDuJeu();
	PlateauTuiles plateauTuiles = new PlateauTuiles();
	Pioche touteLesTuile = new Pioche();
	Joueur joueurTest;
	PlateauDeCase plateauDeCase = PlateauDeCase.initialisationPlateauCase();
	
	@BeforeEach
	public void initialisation() {
		touteLesTuile = Tuile.initialisationTuiles();
		
		Tuile Tuile1 = new Tuile(Couleur.ROUGE, Forme.OISEAU);
		Tuile Tuile2 = new Tuile(Couleur.BLEU, Forme.OISEAU);
		Tuile Tuile3 = new Tuile(Couleur.JAUNE, Forme.FLEUR);
		Tuile Tuile4 = new Tuile(Couleur.VERT, Forme.DAUPHIN);
		Tuile Tuile5 = new Tuile(Couleur.ROUGE, Forme.TORTUE);
		List<Tuile> lerack = new ArrayList<>(Arrays.asList(Tuile1, Tuile2, Tuile3, Tuile4, Tuile5));
		Rack rackJoueur = new Rack(lerack);
			
		joueurTest = new Joueur("J1", 0, 100, 0, rackJoueur, new Pioche() ) ; 
	}

	@Test
	public void testPoserTuileAuCentrePremierTour() {
		assertFalse(joueurTest.poserTuile(3, new Position(3,4), plateauDeCase, plateauTuiles) );
		assertTrue(joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles) );
	}

	@Test
	public void testPasPoserTuileSurTuile() {
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertFalse(joueurTest.poserTuile(2, new Position(4,4), plateauDeCase, plateauTuiles) );
	}

	@Test
	public void testPasPoserTuileSeule() {
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertFalse(joueurTest.poserTuile(2, new Position(2,8), plateauDeCase, plateauTuiles) );
	}
	
	@Test
	public void testTailleRackAvantEtApresPoserTuile() {
		assertEquals(5, joueurTest.getRack().taille());
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertEquals(4, joueurTest.getRack().taille());
	}
	
	@Test
	public void testPoserTuileQuandCorrespond() {
		plateauTuiles.poser(new Position(4,4), new Tuile(Couleur.BLEU,Forme.DAUPHIN));
		plateauTuiles.poser(new Position(3,3), new Tuile(Couleur.BLEU,Forme.DAUPHIN));
		
		System.out.println(joueurTest.getRack().getTuiles().get(2));
		
		assertTrue(joueurTest.poserTuile(1, new Position(3,4), plateauDeCase, plateauTuiles) );
		assertTrue(joueurTest.poserTuile(2, new Position(4,3), plateauDeCase, plateauTuiles) );
		assertFalse(joueurTest.poserTuile(2, new Position(4,3), plateauDeCase, plateauTuiles) );
	}

	@Test
	public void testNbTuilePoserAugment() {
		assertEquals(0 , joueurTest.getNbTuilesPosees() );
		joueurTest.poserTuile(3, new Position(3,4), plateauDeCase, plateauTuiles);
		assertEquals(0 , joueurTest.getNbTuilesPosees() );
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertEquals(1 , joueurTest.getNbTuilesPosees() );
	}

	@Test
	public void testGanerPointQuandDeuxAutour() {
		//TODO
	}

	@Test
	public void testGanerPointQuandTroisAutour() {
		//TODO
	}

	@Test
	public void testGanerPointQuandQuatreAutour() {
		//TODO
	}

	@Test
	public void testGanerPointQuandDeuxAutourEtSurSoleil() {
		//TODO
	}

	@Test
	public void testGanerPointQuandTroisAutourEtSurSoleil() {
		//TODO
	}

	@Test
	public void testGanerPointQuandQuatreAutourEtSurSoleil() {
		//TODO
	}
}
