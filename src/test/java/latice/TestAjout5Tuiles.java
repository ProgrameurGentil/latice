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

public class TestAjout5Tuiles {
	
	MaitreDuJeu maitre = new MaitreDuJeu();
	ArrayList<Tuile> listeDeTuiles = new ArrayList<Tuile>();
	ArrayList<Tuile> listeDeTuilesTest = new ArrayList<Tuile>();
	Pioche pioche;
	Joueur joueur;
	
	@BeforeEach
	public void ajouterDesElementDansLaListePourFaireLesTests() {
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.ROUGE, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.VERT, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.FLEUR));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.DAUPHIN));
		listeDeTuiles.add(new Tuile(Couleur.JAUNE, Forme.FLEUR));
		
		pioche = new Pioche(listeDeTuiles);
		joueur = new Joueur("nom", pioche);
	}
	@Test
    public void testPiocher5Tuiles_DansUnePiocheDe10() {
		System.out.println("------------------------ Test Piocher 5 Tuiles Dans Une Pioche ------------------------");
		System.out.println(listeDeTuiles);
		
        joueur.remplirSonRack();
        joueur.getRack().afficher();
        System.out.println(listeDeTuiles);
        System.out.println("----------------------------------------------------------------------------------------");
        assertEquals(5, joueur.getRack().taille());
	}

	@Test
	public void testPiocherAvecRackNonNull() {
		System.out.println("------------------------ Test Piocher Avec Rack Non Null ------------------------");
		System.out.println(listeDeTuiles);
		Rack rack = new Rack(new ArrayList<Tuile>());
		rack.ajouter(new Tuile(Couleur.BLEU, Forme.DAUPHIN));
		rack.ajouter(new Tuile(Couleur.BLEU, Forme.FLEUR));
		joueur.remplirSonRack();
		joueur.getRack().afficher();
		System.out.println(rack);
        System.out.println(listeDeTuiles);
        System.out.println("----------------------------------------------------------------------------------------");
        assertEquals(5, joueur.getRack().taille());
	}
	
	@Test
	public void testPiocherAvecPiocheNonSupA5() {
		System.out.println("------------------------ Test Piocher Avec Une Pioche Non Supérieure à 5 ------------------------");
		listeDeTuilesTest.add(new Tuile(Couleur.BLEU, Forme.DAUPHIN));
		listeDeTuilesTest.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		listeDeTuilesTest.add(new Tuile(Couleur.ROUGE, Forme.DAUPHIN));
		System.out.println(listeDeTuilesTest);
		Rack rack = new Rack(listeDeTuilesTest);
		joueur.remplirSonRack();
		joueur.getRack().afficher();
		System.out.println(rack);
        System.out.println(listeDeTuilesTest);
        System.out.println("----------------------------------------------------------------------------------------");
        assertEquals(5, joueur.getRack().taille());
	}
}

