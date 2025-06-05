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
		
		Tuile Tuile1 = new Tuile(Couleur.ROUGE, Forme.OISEAU);
		Tuile Tuile2 = new Tuile(Couleur.BLEU, Forme.OISEAU);
		Tuile Tuile3 = new Tuile(Couleur.JAUNE, Forme.FLEUR);
		Tuile Tuile4 = new Tuile(Couleur.VERT, Forme.DAUPHIN);
		Tuile Tuile5 = new Tuile(Couleur.ROUGE, Forme.TORTUE);
		List<Tuile> lerack = new ArrayList<>(Arrays.asList(Tuile1, Tuile2, Tuile3, Tuile4, Tuile5));
		Rack rackJoueur = new Rack(lerack);
			
		Joueur joueurTest = new Joueur("J1", 0, 100, 0, rackJoueur, new Pioche() ) ; 
	}

	@test
	public void testPoserTuileAuCentrePremierTour() {
		assertFalse(joueurTest.poserTuile(3, new Position(3,4), plateauDeCase, plateauTuiles) );
		assertTrue(joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles) );
	}

	@test
	public void testPasPoserTuileSurTuile() {
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertFalse(joueurTest.poserTuile(2, new Position(4,4), plateauDeCase, plateauTuiles) );
	}

	@test
	public void testPasPoserTuileSeule() {
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertFalse(joueurTest.poserTuile(2, new Position(2,8), plateauDeCase, plateauTuiles) );
	}
	
	@test
	public void testTailleRackAvantEtApresPoserTuile() {
		assertEquals(5, joueurTest.getRack().taille());
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertEquals(4, joueurTest.getRack().taille());
	}
	
	@test
	public void testPoserTuileQuandCorrespond() {
		plateauTuiles.poser(new Position(4,4), new Tuile(Couleur.BLEU,Forme.DAUPHIN));
		plateauTuiles.poser(new Position(3,3), new Tuile(Couleur.BLEU,Forme.FLEUR));
		
		assertTrue(joueurTest.poserTuile(2, new Position(3,4), plateauDeCase, plateauTuiles) );
		assertTrue(joueurTest.poserTuile(4, new Position(4,3), plateauDeCase, plateauTuiles) );
		assertFalse(joueurTest.poserTuile(3, new Position(4,3), plateauDeCase, plateauTuiles) );
	}

	@test
	public void testNbTuilePoserAugment() {
		assertEquals(0 , joueurTest.getNbTuilePose() );
		joueurTest.poserTuile(3, new Position(3,4), plateauDeCase, plateauTuiles);
		assertEquals(0 , joueurTest.getNbTuilePose() );
		joueurTest.poserTuile(3, new Position(4,4), plateauDeCase, plateauTuiles);
		assertEquals(1 , joueurTest.getNbTuilePose() );
	}

	@test
	public void testGanerPointQuandDeuxAutour() {
		//TODO
	}

	@test
	public void testGanerPointQuandTroisAutour() {
		//TODO
	}

	@test
	public void testGanerPointQuandQuatreAutour() {
		//TODO
	}

	@test
	public void testGanerPointQuandDeuxAutourEtSurSoleil() {
		//TODO
	}

	@test
	public void testGanerPointQuandTroisAutourEtSurSoleil() {
		//TODO
	}

	@test
	public void testGanerPointQuandQuatreAutourEtSurSoleil() {
		//TODO
	}
}
