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
        ArrayList<Tuile> rack = maitre.piocher5Tuiles(listeDeTuiles);

        // Vérifie que 5 tuiles ont été piochées
        assertEquals(5, rack.size(), "Le rack doit contenir 5 tuiles");

        // Vérifie que la pioche a été réduite à 5 tuiles
        assertEquals(5, listeDeTuiles.size(), "La pioche doit maintenant contenir 5 tuiles");

        // Vérifie que les bonnes tuiles ont été piochées (les 5 premières)
        assertEquals(new Tuile(Couleur.BLEU, Forme.DOPHIN), rack.get(0));
        assertEquals(new Tuile(Couleur.BLEU, Forme.FLEUR), rack.get(1));
        assertEquals(new Tuile(Couleur.ROUGE, Forme.DOPHIN), rack.get(2));
        assertEquals(new Tuile(Couleur.ROUGE, Forme.FLEUR), rack.get(3));
        assertEquals(new Tuile(Couleur.VERT, Forme.DOPHIN), rack.get(4));
    }
}
