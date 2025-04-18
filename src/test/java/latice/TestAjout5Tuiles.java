package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.model.Couleur;
import latice.model.Forme;
import latice.model.MaitreDuJeu;
import latice.model.Tuile;

public class TestAjout5Tuiles {
	
	MaitreDuJeu maitre = new MaitreDuJeu();
	ArrayList<Tuile> listeDeTuiles = new ArrayList<Tuile>();
	ArrayList<Tuile> listeDeTuilesTest = new ArrayList<Tuile>();
	
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
    public void testPiocher5Tuiles_DansUnePiocheDe10() {
		System.out.println("------------------------ Test Piocher 5 Tuiles Dans Une Pioche ------------------------");
		System.out.println(listeDeTuiles);
		ArrayList<Tuile> rack = new ArrayList<Tuile>();
        rack = maitre.piocher5Tuiles(listeDeTuiles, rack);

        for (int i = 0; i < rack.size(); i++) {
            System.out.println(i);
            System.out.println(rack.get(i));
    }
        System.out.println(listeDeTuiles);
        System.out.println("----------------------------------------------------------------------------------------");
}

	@Test
	public void testPiocherAvecRackNonNull() {
		System.out.println("------------------------ Test Piocher Avec Rack Non Null ------------------------");
		System.out.println(listeDeTuiles);
		ArrayList<Tuile> rack = new ArrayList<Tuile>();
		rack.add(new Tuile(Couleur.BLEU, Forme.DOPHIN));
		rack.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		rack = maitre.piocher5Tuiles(listeDeTuiles, rack);
		for (int i = 0; i < rack.size(); i++) {
            System.out.println(i);
            System.out.println(rack.get(i));
    }
		System.out.println(rack);
        System.out.println(listeDeTuiles);
        System.out.println("----------------------------------------------------------------------------------------");
	}
	@Test
	public void testPiocherAvecPiocheNonSupA5() {
		System.out.println("------------------------ Test Piocher Avec Une Pioche Non Supérieure à 5 ------------------------");
		listeDeTuilesTest.add(new Tuile(Couleur.BLEU, Forme.DOPHIN));
		listeDeTuilesTest.add(new Tuile(Couleur.BLEU, Forme.FLEUR));
		listeDeTuilesTest.add(new Tuile(Couleur.ROUGE, Forme.DOPHIN));
		System.out.println(listeDeTuilesTest);
		ArrayList<Tuile> rack = new ArrayList<Tuile>();
		rack = maitre.piocher5Tuiles(listeDeTuilesTest, rack);
		for (int i = 0; i < rack.size(); i++) {
            System.out.println(i);
            System.out.println(rack.get(i));
		}
		System.out.println(rack);
        System.out.println(listeDeTuilesTest);
        System.out.println("----------------------------------------------------------------------------------------");
	}
}

